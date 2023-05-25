part of clients;

class DetailClientsScreen extends StatefulWidget {
  const DetailClientsScreen({
    super.key,
    required this.clientId,
  });

  final String clientId;

  @override
  State<DetailClientsScreen> createState() => _DetailClientsScreenState();
}

class _DetailClientsScreenState extends State<DetailClientsScreen> {

  late Child child;
  late TextEditingController addInfoController;

  bool editing = false;

  @override
  void initState() {
    super.initState();
    addInfoController = TextEditingController();
  }

  @override
  void dispose() {
    super.dispose();
    addInfoController.dispose();
  }

  @override
  Widget build(BuildContext context) {
    final clientsController = context.watch<ClientsController>();
    child = clientsController.getAll<Child>(widget.clientId).first;
    return Scaffold(
      appBar: AppBar(
        title: const Text(
          'Information',
          style: TextStyle(
            fontWeight: FontWeight.w500,
          ),
        ),
      ),
      body: ListView(
        children: <Widget>[
          buildHeader(context),
          for (var info in child.informations)
            ChildInformationWidget(
            info: info,
            ),
          if (!editing)
            TextButton.icon(
              onPressed: (){
                setState(() => editing = !editing);
              },
              icon: const Icon(Icons.add),
              label: const Text('Add Information'),
            ),
          if (editing)
            ListTile(
              leading: const Icon(Icons.new_label),
              title: TextField(
                controller: addInfoController,
                decoration: const InputDecoration(
                  hintText: 'New Information Title',
                ),
              ),
              trailing: TextButton(
                onPressed: () {
                  if (addInfoController.text.isNotEmpty) {
                    setState(() {
                      child.informations.add(
                        Information(
                          icon: Icons.label,
                          title: addInfoController.text,
                          items: <String, String?>{},
                        ),
                      );
                      addInfoController.clear();
                      editing = !editing;
                    });
                  }
                },
                child: const Icon(Icons.add),
              ),
            ),
        ],
      ),
    );
  }

  Widget buildHeader(BuildContext context) {
    final parent = context.read<ClientsController>().getParent(child.parentId);
    return ListTile(
      leading: CircleAvatar(
        radius: 60.0,
        child: ClipRRect(
          borderRadius: BorderRadius.circular(60.0),
          child: Image.asset(child.picture),
        ),
      ),
      subtitle: Column(
        mainAxisSize: MainAxisSize.max,
        mainAxisAlignment: MainAxisAlignment.start,
        children: <Widget>[
          IconTextWidget(
            icon: Icons.show_chart_rounded,
            text: '${child.age} year old',
          ),
          IconTextWidget(
            icon: Icons.family_restroom,
            text: parent.name,
          ),
          IconTextWidget(
            icon: Icons.phone,
            text: parent.phone,
          ),
        ],
      ),
      title: Text(child.name),
    );
  }
}
