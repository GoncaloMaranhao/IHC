library messages;

import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';
import 'package:provider/provider.dart';

import '../../models/models.dart';
import '../../providers/providers.dart';
import '../../widgets/widgets.dart';

part 'all.dart';
part 'conversation.dart';

///
class MessagesScreen extends StatelessWidget {
  ///
  const MessagesScreen._({
    super.key,
    required Widget child,
  }) : _child = child;

  const MessagesScreen.all({
    Key? key,
  }) : this._(
    key: key,
    child: const AllMessagesScreen(),
  );

  MessagesScreen.conversation({
    Key? key,
    required String clientId,
  }) : this._(
    key: key,
    child: ConversationMessagesScreen(
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
