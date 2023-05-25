library widgets;

import 'package:flutter/material.dart';
import 'package:intl/intl.dart';

import '../models/models.dart';

part 'appointment.dart';
part 'client.dart';

class IconTextWidget extends StatelessWidget {
  const IconTextWidget({
    super.key,
    this.icon,
    this.text,
  });

  final IconData? icon;

  final String? text;

  @override
  Widget build(BuildContext context) {
    final style = DefaultTextStyle.of(context).style;
    return Row(
      children: <Widget>[
        Icon(icon),
        const SizedBox(width: 8.0,),
        FittedBox(
          child: Text(
            text ?? '',
            style: style.copyWith(
              color: style.color?.withOpacity(0.6),
              fontWeight: FontWeight.w500,
            ),
            overflow: TextOverflow.ellipsis,
          ),
        ),
      ],
    );
  }
}

class ChildInformationWidget extends StatefulWidget {
  const ChildInformationWidget({
    super.key,
    required this.info,
  });

  final Information info;

  @override
  State<ChildInformationWidget> createState() => _ChildInformationWidgetState();
}

class _ChildInformationWidgetState extends State<ChildInformationWidget> {

  late TextEditingController titleController;
  late TextEditingController descriptionController;

  bool editing = false;

  late Information info;

  @override
  void initState() {
    super.initState();
    info = widget.info;
    titleController = TextEditingController();
    descriptionController = TextEditingController();
  }

  @override
  void dispose() {
    super.dispose();
    titleController.dispose();
    descriptionController.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return ExpansionTile(
      leading: Icon(info.icon),
      title: Text(info.title),
      children: <Widget>[
        for (var item in info.items.keys)
          ListTile(
            title: Text(item),
            subtitle: info.items[item] != null ? Text(info.items[item]!) : null,
            trailing: TextButton(
              onPressed: () {
                setState((){
                  info.items.remove(item);
                });
              },
              child: const Icon(Icons.delete),
            ),
          ),
        if (editing)
          ListTile(
            title: TextField(
              controller: titleController,
              decoration: InputDecoration(
                icon: const Icon(Icons.edit),
                hintText: '${info.title} name',
              ),
            ),
            subtitle: TextField(
              controller: descriptionController,
              decoration: InputDecoration(
                icon: const Icon(Icons.edit),
                hintText: '${info.title} description',
              ),
            ),
            trailing: TextButton(
              onPressed: () {
                if (titleController.text.isNotEmpty) {
                  setState((){
                    info.items[titleController.text] =
                      descriptionController.text.isEmpty
                      ? null
                      : descriptionController.text;
                  });
                  titleController.clear();
                  descriptionController.clear();
                  editing = !editing;
                }
              },
              child: const Icon(Icons.add),
            ),
          ),
        if (!editing)
          TextButton.icon(
            onPressed: (){
              setState(() => editing = !editing);
            },
            icon: const Icon(Icons.add),
            label: Text('Add ${info.title}'),
          ),
      ],
    );
  }
}
