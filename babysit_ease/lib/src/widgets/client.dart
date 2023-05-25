part of widgets;

abstract class ClientWidget<T extends Client> extends StatelessWidget {
  const ClientWidget({
    super.key,
    required this.client,
  });

  final T client;
}

class ClientListTile<T extends Client> extends ClientWidget<T> {
  const ClientListTile({
    super.key,
    this.onTap,
    required super.client,
  });

  final VoidCallback? onTap;

  @override
  Widget build(BuildContext context) {
    assert(debugCheckHasMaterial(context));
    return ListTile(
      onTap: onTap,
      leading: CircleAvatar(
        radius: 28.0,
        child: ClipRRect(
          borderRadius: BorderRadius.circular(28.0),
          child: Image.asset(client.picture),
        ),
      ),
      title: Text(client.name),
      subtitle: IconTextWidget(
        icon: client is Child ? Icons.show_chart_rounded : Icons.phone,
        text: client is Child ? '${(client as Child).age} year old' : (client as Parent).phone,
      ),
    );
  }
}
