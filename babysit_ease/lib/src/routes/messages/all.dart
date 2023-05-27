part of messages;

class AllMessagesScreen extends StatelessWidget {
  const AllMessagesScreen({super.key});

  @override
  Widget build(BuildContext context) {
    final parents = context.read<ClientsController>().getAll<Parent>();
    return Scaffold(
      appBar: AppBar(
        title: const Text(
          'Messages',
          style: TextStyle(
            fontWeight: FontWeight.w500,
          ),
        ),
      ),
      body: ListView(
        children: ListTile.divideTiles(
          context: context,
          tiles: <Widget>[
            for (var parent in parents)
              ClientListTile<Parent>(
                onTap: () => context.go('/messages/${parent.cid}'),
                client: parent,
              ),
          ],
        ).toList(),
      ),
    );
  }
}
