library appointment;

import 'package:babysit_ease/src/models/models.dart';
import 'package:babysit_ease/src/providers/providers.dart';
import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';
import 'package:intl/intl.dart';
import 'package:provider/provider.dart';

part 'add.dart';

///
class AppointmentScreen extends StatelessWidget {
  ///
  const AppointmentScreen._({
    super.key,
    required Widget child,
  }) : _child = child;

  AppointmentScreen.add({
    Key? key,
    DateTime? selectedDay,
  }) : this._(
    key: key,
    child: AddAppointmentScreen(
      selectedDay: selectedDay,
    ),
  );

  ///
  final Widget _child;

  @override
  Widget build(BuildContext context) {
    return _child;
  }
}
