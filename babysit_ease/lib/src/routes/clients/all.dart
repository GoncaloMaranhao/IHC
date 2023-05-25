part of clients;

class AllClientsScreen extends StatelessWidget {
  const AllClientsScreen({super.key});

  @override
  Widget build(BuildContext context) {
    final children = context.read<ClientsController>().getAll<Child>();
    return Scaffold(
      appBar: AppBar(
        title: const Text(
          'Clients',
          style: TextStyle(
            fontWeight: FontWeight.w500,
          ),
        ),
      ),
      body: ListView(
        children: ListTile.divideTiles(
          context: context,
          tiles: <Widget>[
            for (var child in children)
              ClientListTile<Child>(
                client: child,
                onTap: () => context.go('/clients/${child.cid}'),
              ),
          ],
        ).toList(),
      ),
    );
  }
}
