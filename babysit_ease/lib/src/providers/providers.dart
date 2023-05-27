library providers;

import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import 'package:provider/single_child_widget.dart';

import '../models/models.dart';

part 'controllers.dart';
part 'storage.dart';


List<SingleChildWidget> get providers => <SingleChildWidget>[
  Provider<Storage>(
    create: (_) => MemoryStorage(),
  ),
  Provider<AuthController>(
    create: (context) => AuthController(
      context.read<Storage>(),
    ),
  ),
  Provider<AppointmentsController>(
    create: (context) => AppointmentsController(
      context.read<Storage>(),
    ),
  ),
  Provider<ClientsController>(
    create: (context) => ClientsController(
      context.read<Storage>(),
    ),
  ),
];
