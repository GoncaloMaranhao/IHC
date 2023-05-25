part of messages;

class ConversationMessagesScreen extends StatefulWidget {
  const ConversationMessagesScreen({
    super.key,
    required this.clientId,
  });

  final String clientId;

  @override
  State<ConversationMessagesScreen> createState() => _ConversationMessagesScreenState();
}

class _ConversationMessagesScreenState extends State<ConversationMessagesScreen> {

  late TextEditingController controller;
  late Parent parent;

  @override
  void initState() {
    super.initState();

    controller = TextEditingController();
  }

  @override
  void dispose() {
    super.dispose();

    controller.dispose();
  }

  @override
  Widget build(BuildContext context) {
    final theme = Theme.of(context);
    parent = context.read<ClientsController>().getParent(widget.clientId);
    return Scaffold(
      appBar: AppBar(
        title: Text(
          parent.name,
          style: const TextStyle(
            fontWeight: FontWeight.w500,
          ),
        ),
      ),
      body: Stack(
        children: [
          ListView.separated(
            itemCount: parent.messages.length,
            itemBuilder: (context, index) {
              final message = parent.messages[index];
              final icon = CircleAvatar(
                radius: 28.0,
                child: ClipRRect(
                  borderRadius: BorderRadius.circular(28.0),
                  child: Image.asset(
                    message.id.isEmpty ? 'assets/images/beatriz-silva.png' : parent.picture,
                  ),
                ),
              );
              return ListTile(
                title: Text(message.content),
                subtitle: Text('${message.dateTime}'),
                trailing: message.id.isEmpty ? icon : null,
                leading: message.id.isNotEmpty ? icon : null,
              );
            }, separatorBuilder: (context, index) => const Divider(),
          ),
          Align(
            alignment: Alignment.bottomCenter,
            child: Container(
              decoration: BoxDecoration(
                color: theme.colorScheme.surfaceVariant,
              ),
              child: Padding(
                padding: const EdgeInsets.all(8.0),
                child: Row(
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: [
                    Expanded(
                      child: TextField(
                        controller: controller,
                        decoration: const InputDecoration(
                          hintText: 'Type a message...',
                        ),
                      ),
                    ),
                    TextButton(
                      onPressed: () {
                        if (controller.text.isNotEmpty) {
                          setState(() =>
                            parent.messages.add(
                              Message(
                                id: '',
                                content: controller.text,
                                dateTime: DateTime.now(),
                              ),
                            )
                          );
                          controller.clear();
                        }
                      },
                      child: const Icon(Icons.send),
                    ),
                  ],
                ),
              ),
            ),
          ),
        ],
      ),
    );
  }
}
