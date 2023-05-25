
import 'package:flutter/material.dart';


abstract class Model {}

abstract class Client implements Model {
  const Client({
    required this.cid,
    required this.name,
    required this.picture,
  });

  final String cid;
  final String name;
  final String picture;
}

class Child extends Client {
  const Child({
    required super.cid,
    required super.name,
    required super.picture,
    required this.age,
    required this.parentId,
    this.informations = const [],
  });

  final int age;
  final String parentId;
  final List<Information> informations;
}

class Parent extends Client {
  Parent({
    required super.cid,
    required super.name,
    required super.picture,
    required this.address,
    required this.phone,
    required this.messages,
  });

  final String address;
  final String phone;
  final List<Message> messages;
}

@immutable
class Appointment implements Model {
  const Appointment({
    required this.title,
    required this.child,
    required this.date,
    required this.start,
    required this.end,
    required this.address,
  });

  final String title;
  final DateTime date;
  final TimeOfDay start, end;
  final Child child;
  final String address;
}

class User implements Model {
  const User({
    required this.name,
    required this.email,
    required this.password,
  });

  final String name;
  final String email;
  final String password;
}


class Message implements Model {
  Message({
    required this.id,
    required this.dateTime,
    required this.content,
  });

  final String id;
  final DateTime dateTime;
  final String content;
}

class Information implements Model {
  Information({
    required this.title,
    required this.icon,
    required this.items,
  });

  final String title;
  final IconData icon;
  final Map<String, String?> items;
}
