
import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';
import 'package:intl/intl.dart';
import 'package:provider/provider.dart';
import 'package:table_calendar/table_calendar.dart';

import '../../models/models.dart';
import '../../providers/providers.dart';
import '../../widgets/widgets.dart';

class HomeScreen extends StatefulWidget {
  const HomeScreen({super.key});

  @override
  State<HomeScreen> createState() => _HomeScreenState();
}

class _HomeScreenState extends State<HomeScreen> {
  final GlobalKey<ScaffoldState> scaffoldKey = GlobalKey<ScaffoldState>();

  late DateTime focusedDay;
  late DateTime selectedDay;

  @override
  void initState() {
    super.initState();

    final now = DateTime.now();
    focusedDay = DateTime.utc(now.year, now.month, now.day);
    selectedDay = focusedDay;
  }

  @override
  Widget build(BuildContext context) {
    final authController = context.read<AuthController>();
    final theme = Theme.of(context);
    return Scaffold(
      key: scaffoldKey,
      appBar: AppBar(
        leading: TextButton(
          onPressed: () => scaffoldKey.currentState?.openDrawer(),
          child: CircleAvatar(
            radius: 24.0,
            child: ClipRRect(
              borderRadius: BorderRadius.circular(50.0),
              child: Image.asset('assets/images/beatriz-silva.png'),
            ),
          ),
        ),
        title: Text(
          'Hello, ${authController.current?.name}!',
          style: const TextStyle(
            fontWeight: FontWeight.w500,
          ),
        ),
      ),
      drawer: Drawer(
        child: ListView(
          children: <Widget>[
            UserAccountsDrawerHeader(
              currentAccountPicture: CircleAvatar(
                child: ClipRRect(
                  borderRadius: BorderRadius.circular(72.0),
                  child: Image.asset('assets/images/beatriz-silva.png'),
                ),
              ),
              accountName: Text(
                authController.current?.name ?? '',
                style: TextStyle(
                  fontWeight: FontWeight.w500,
                  color: theme.colorScheme.background,
                ),
              ),
              accountEmail: Text(
                authController.current?.email?? '',
                style: TextStyle(
                  color: theme.colorScheme.background,
                ),
              ),
            ),
            ListTile(
              onTap: () => context.go('/messages'),
              leading: const Icon(Icons.message),
              title: const Text('Messages'),
            ),
            ListTile(
              onTap: () => context.go('/clients'),
              leading: const Icon(Icons.people),
              title: const Text('Clients'),
            ),
            ListTile(
              onTap: () => context.go('/appointment/add'),
              leading: const Icon(Icons.add),
              title: const Text('Add Appointment'),
            ),
            ListTile(
              onTap: () {
                authController.logout();
                context.pushReplacement('/');
              },
              leading: const Icon(Icons.logout),
              title: const Text('Log Out'),
            ),
          ],
        ),
      ),
      body: Column(
        mainAxisAlignment: MainAxisAlignment.start,
        children: <Widget>[
          buildCalendar(context),
          const Divider(),
          buildActionRow(context),
          const SizedBox(height: 8.0),
          buildAppointmentList(context),
        ],
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: () => context.go(
          '/appointment/add',
          extra: selectedDay,
        ),
        child: const Icon(Icons.add),
      ),
    );
  }

  Widget buildCalendar(BuildContext context) {
    final appointmentsController = context.read<AppointmentsController>();
    return TableCalendar<Appointment>(
      focusedDay: focusedDay,
      firstDay: DateTime.utc(2022),
      lastDay: DateTime.utc(2024),
      availableCalendarFormats: const {
        CalendarFormat.month: 'Month',
      },
      selectedDayPredicate: (day) => isSameDay(selectedDay, day),
      onDaySelected: (selectedDay, focusedDay) {
        setState(() {
          this.selectedDay = selectedDay;
          this.focusedDay = focusedDay;
        });
      },
      eventLoader: (day) => appointmentsController.fetchToday(day),
    );
  }

  Widget buildActionRow(BuildContext context) {
    return SingleChildScrollView(
      scrollDirection: Axis.horizontal,
      child: Row(
        mainAxisAlignment: MainAxisAlignment.spaceAround,
        children: <Widget>[
          const SizedBox(width: 8.0),
          ElevatedButton.icon(
            onPressed: () => context.go('/messages'),
            icon: const Icon(Icons.message),
            label: const Text('Messages'),
          ),
          const SizedBox(width: 8.0),
          ElevatedButton.icon(
            onPressed: () => context.go('/clients'),
            icon: const Icon(Icons.people),
            label: const Text('Clients'),
          ),
          const SizedBox(width: 8.0),
          ElevatedButton.icon(
            onPressed: () => context.go('/appointment/add'),
            icon: const Icon(Icons.add),
            label: const Text('Add Appointment'),
          ),
          const SizedBox(width: 8.0),
        ],
      ),
    );
  }

  Widget buildAppointmentList(BuildContext context) {
    final theme = Theme.of(context);
    final dateFormatter = DateFormat.yMEd();
    final appointments = context.read<AppointmentsController>().fetchToday(selectedDay);
    if (appointments.isEmpty) {
      return Expanded(
        child: Center(
          child: RichText(
            text: TextSpan(
              style: theme.textTheme.bodyLarge?.copyWith(
                color: theme.textTheme.bodyLarge?.color?.withOpacity(0.6),
              ),
              text: 'No appointments on ',
              children: <InlineSpan>[
                TextSpan(
                  text: dateFormatter.format(selectedDay),
                  style: const TextStyle(fontWeight: FontWeight.bold),
                ),
              ],
            ),
          ),
        ),
      );
    } else {
      return Expanded(
        child: ListView(
          children: <Widget>[
            ListTile(
              visualDensity: const VisualDensity(vertical: -4),
              title: RichText(
                text: TextSpan(
                  style: theme.textTheme.bodyLarge?.copyWith(
                    color: theme.textTheme.bodyLarge?.color?.withOpacity(0.6),
                  ),
                  text: 'Appointments on ',
                  children: <InlineSpan>[
                    TextSpan(
                      text: dateFormatter.format(selectedDay),
                      style: const TextStyle(fontWeight: FontWeight.bold),
                    ),
                  ],
                ),
              ),
            ),
            for (var appointment in appointments)
              AppointmentListTile(
                appointment: appointment,
              ),
          ],
        ),
      );
    }
  }
}
