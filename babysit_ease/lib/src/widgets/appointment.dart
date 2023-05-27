part of widgets;

abstract class AppointmentWidget extends StatelessWidget {
  const AppointmentWidget({
    super.key,
    required this.appointment,
  });

  final Appointment appointment;
}

class AppointmentListTile extends AppointmentWidget {
  const AppointmentListTile({
    super.key,
    required super.appointment,
  });

  @override
  Widget build(BuildContext context) {
    assert(debugCheckHasMaterial(context));
    final dateFormatter = DateFormat.yMMMEd();
    return ExpansionTile(
      leading: CircleAvatar(
        radius: 24.0,
        child: ClipRRect(
          borderRadius: BorderRadius.circular(24.0),
          child: Image.asset(appointment.child.picture),
        ),
      ),
      title: Text(appointment.title),
      subtitle: IconTextWidget(
        icon: Icons.alarm,
        text: '${appointment.start.format(context)}-${appointment.end.format(context)}'
      ),
      children: <Widget>[
        const ListTile(
          visualDensity: VisualDensity(vertical: -4),
          title: Text('Information'),
        ),
        ListTile(
          visualDensity: const VisualDensity(vertical: -4),
          title: IconTextWidget(
            icon: Icons.boy,
            text: appointment.child.name,
          ),
        ),
        ListTile(
          visualDensity: const VisualDensity(vertical: -4),
          title: IconTextWidget(
            icon: Icons.show_chart_rounded,
            text: '${appointment.child.age} year old',
          ),
        ),
        ListTile(
          visualDensity: const VisualDensity(vertical: -4),
          title: IconTextWidget(
            icon: Icons.pin_drop,
            text: appointment.address,
          ),
        ),
        ListTile(
          visualDensity: const VisualDensity(vertical: -4),
          title: IconTextWidget(
            icon: Icons.calendar_today,
            text: dateFormatter.format(appointment.date),
          ),
        ),
      ],
    );
  }
}
