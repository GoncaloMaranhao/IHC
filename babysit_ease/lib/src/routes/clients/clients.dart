library clients;

import 'package:babysit_ease/src/models/models.dart';
import 'package:babysit_ease/src/providers/providers.dart';
import 'package:babysit_ease/src/widgets/widgets.dart';
import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';
import 'package:provider/provider.dart';

part 'all.dart';
part 'detail.dart';

///
class ClientsScreen extends StatelessWidget {
  ///
  const ClientsScreen._({
    super.key,
    required Widget child,
  }) : _child = child;

  const ClientsScreen.all({
    Key? key,
  }) : this._(
    key: key,
    child: const AllClientsScreen(),
  );

  ClientsScreen.detail({
    Key? key,
    required String clientId,
  }) : this._(
    key: key,
    child: DetailClientsScreen(
      clientId: clientId,
    ),
  );

  ///
  final Widget _child;

  @override
  Widget build(BuildContext context) {
    return _child;
  }
}
