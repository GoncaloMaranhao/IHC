part of appointment;

class AddAppointmentScreen extends StatefulWidget {
  const AddAppointmentScreen({
    super.key,
    this.selectedDay,
  });

  final DateTime? selectedDay;

  @override
  State<AddAppointmentScreen> createState() => _AddAppointmentScreenState();
}

class _AddAppointmentScreenState extends State<AddAppointmentScreen> {
  final GlobalKey<ScaffoldState> scaffoldKey = GlobalKey<ScaffoldState>();
  final GlobalKey<FormState> formKey = GlobalKey<FormState>();
  final DateFormat dateFormatter = DateFormat.yMMMEd();
  final DateFormat timeFormatter = DateFormat.Hms();

  DateTime? selectedDay;
  TimeOfDay? startTime, endTime;
  Child? child;

  late TextEditingController titleController;

  late ClientsController clientController;
  late AppointmentsController appointmentController;

  @override
  void initState() {
    super.initState();

    selectedDay = widget.selectedDay;
    titleController = TextEditingController();
  }

  @override
  void dispose() {
    super.dispose();

    titleController.dispose();
  }

  @override
  Widget build(BuildContext context) {
    clientController = context.read<ClientsController>();
    appointmentController = context.read<AppointmentsController>();
    return Scaffold(
      key: scaffoldKey,
      appBar: AppBar(
        title: const Text(
          'Add Appointment',
          style: TextStyle(
            fontWeight: FontWeight.w500,
          ),
        ),
      ),
      body: Form(
        key: formKey,
        child: Padding(
            padding: const EdgeInsets.all(24.0),
            child: ListView(
              children: <Widget>[
                buildTitleFormField(context),
                const SizedBox(height: 24.0,),
                buildDateFormField(context),
                const SizedBox(height: 24.0,),
                buildStartAndEndTimeFormField(context),
                const SizedBox(height: 8.0,),
                const Divider(),
                const SizedBox(height: 8.0,),
                TextFormField(
                  controller: TextEditingController(text: child?.name),
                  readOnly: true,
                  validator: (value) {
                    if (value == null || value.isEmpty) {
                      return 'Child is required';
                    }
                    return null;
                  },
                  onTap: () async {
                    final child = await showModalBottomSheet<Child>(
                      context: context,
                      builder: (context) {
                        final childs = clientController.getAll<Child>();
                        return Center(
                          child: ListView(
                            children: <Widget>[
                              for (var child in childs)
                                ListTile(
                                  leading: CircleAvatar(
                                    child: ClipRRect(
                                      borderRadius: BorderRadius.circular(24.0),
                                      child: Image.asset(child.picture),
                                    ),
                                  ),
                                  title: Text(child.name),
                                  onTap: () => Navigator.of(context).pop<Child>(child),
                                ),
                            ],
                          ),
                        );
                      }
                    );
                    setState(() => this.child = child);
                  },
                  decoration: const InputDecoration(
                    label: Text('Select Child'),
                    border: OutlineInputBorder(),
                    prefixIcon: Icon(Icons.child_care),
                  ),
                ),
                const SizedBox(height: 12.0,),
                buildDoneButtonFormField(context),
              ],
            ),
          ),
      ),
    );
  }

  Widget buildTitleFormField(BuildContext context) {
    final theme = Theme.of(context);
    return TextFormField(
      controller: titleController,
      keyboardType: TextInputType.text,
      style: theme.textTheme.headlineLarge?.copyWith(
        fontWeight: FontWeight.bold,
      ),
      decoration: const InputDecoration(
        icon: Icon(Icons.title, size: 32.0),
        hintText: 'Appointment Title',
        border: InputBorder.none,
      ),
      validator: (value) {
        if (value == null || value.isEmpty) {
          return 'Appointment title is required';
        }
        return null;
      },
    );
  }

  Widget buildDateFormField(BuildContext context) {
    final theme = Theme.of(context);
    return TextFormField(
      controller: TextEditingController(text: dateFormatter.format(selectedDay ?? DateTime.now())),
      readOnly: true,
      validator: (value) {
        if (value == null || value.isEmpty) {
          return 'Appointment date is required';
        }
        return null;
      },
      style: theme.textTheme.bodyLarge?.copyWith(
        fontWeight: FontWeight.w400,
      ),
      decoration: const InputDecoration(
        label: Text('Date'),
        border: OutlineInputBorder(),
        prefixIcon: Icon(Icons.calendar_today),
      ),
      onTap: () async {
        DateTime? selectedDay = await showDatePicker(
          context: context,
          initialDate: this.selectedDay ?? DateTime.now(),
          firstDate: DateTime.utc(2022),
          lastDate: DateTime.utc(2024),
        );
        setState(() {
          this.selectedDay = selectedDay;
        });
      },
    );
  }

  Widget buildStartAndEndTimeFormField(BuildContext context) {
    final theme = Theme.of(context);
    return Row(
      mainAxisSize: MainAxisSize.min,
      mainAxisAlignment: MainAxisAlignment.center,
      children: <Widget>[
        Flexible(
          child: TextFormField(
            controller: TextEditingController(text: startTime?.format(context)),
            keyboardType: TextInputType.datetime,
            readOnly: true,
            onTap: () async {
              TimeOfDay? startTime = await showTimePicker(
                context: context,
                initialTime: this.startTime ?? TimeOfDay.now(),
              );
              setState(() => this.startTime = startTime);
            },
            validator: (value) {
              if (value == null || value.isEmpty) {
                return 'required';
              }
              return null;
            },
            style: theme.textTheme.bodyLarge?.copyWith(
              fontWeight: FontWeight.w400,
            ),
            decoration: const InputDecoration(
              label: Text('Start Time'),
              border: OutlineInputBorder(),
              prefixIcon: Icon(Icons.login),
            ),
          ),
        ),
        const SizedBox(width: 20.0),
        Flexible(
          child: TextFormField(
            controller: TextEditingController(text: endTime?.format(context)),
            keyboardType: TextInputType.datetime,
            readOnly: true,
            onTap: () async {
              TimeOfDay? endTime = await showTimePicker(
                context: context,
                initialTime: this.endTime ?? TimeOfDay.now(),
              );
              setState(() => this.endTime = endTime);
            },
            validator: (value) {
              if (value == null || value.isEmpty) {
                return 'required';
              }
              return null;
            },
            style: theme.textTheme.bodyLarge?.copyWith(
              fontWeight: FontWeight.w400,
            ),
            decoration: const InputDecoration(
              label: Text('End Time'),
              border: OutlineInputBorder(),
              prefixIcon: Icon(Icons.logout),
            ),
          ),
        ),
      ],
    );
  }

  Widget buildDoneButtonFormField(BuildContext context) {
    return ButtonTheme(
      textTheme: ButtonTextTheme.primary,
      height: 100.0,
      minWidth: 300.0,
      child: FractionallySizedBox(
        widthFactor: 1,
        child: FilledButton(
          onPressed: () {
            if (!formKey.currentState!.validate()) {
              return;
            }
            if (appointmentController.add(
              title: titleController.text,
              date: selectedDay!,
              start: startTime!,
              end: endTime!,
              child: child!
            )) {
              context.pop();
            }
          },
          child: const Text('Done', style: TextStyle(fontSize: 20)),
        ),
      ),
    );
  }
}
