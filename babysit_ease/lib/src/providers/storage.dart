part of providers;

abstract class Storage {
  List<T> get<T extends Model>(String bucket);
  void add<T extends Model>(String bucket, T value);
}

class MemoryStorage implements Storage {
  final Map<String, List<Model>> _storage = <String, List<Model>>{
    'users': const <User>[
      User(
        name: 'Beatriz Silva',
        email: 'beatriz.silva@gmail.com',
        password: 'password123',
      ),
    ],
    'appointments': <Appointment>[
      Appointment(
        title: 'Carvalho Home',
        date: DateTime.utc(2023, 5, 12),
        start: const TimeOfDay(hour: 9, minute: 0),
        end: const TimeOfDay(hour: 16, minute: 0),
        address: '2726 Colony Street, Stamford, CT',
        child: const Child(
          cid: 'ezHNYJ5z7AwTBJndnt',
          name: 'Maria Carvalho',
          picture: 'assets/images/maria-carvalho.jpg',
          age: 5,
          parentId: 'lQIvS2Rw3PdaWEhA4a'
        ),
      ),
      Appointment(
        title: 'Carvalho Home',
        date: DateTime.utc(2023, 5, 27),
        start: const TimeOfDay(hour: 9, minute: 0),
        end: const TimeOfDay(hour: 14, minute: 0),
        address: '2726 Colony Street, Stamford, CT',
        child: const Child(
          cid: 'NSh79WPgYm4I14kGP9',
          name: 'Pedro Carvalho',
          picture: 'assets/images/pedro-carvalho.jpg',
          age: 8,
          parentId: 'lQIvS2Rw3PdaWEhA4a',
        ),
      ),
      Appointment(
        title: 'Mendes Home',
        date: DateTime.utc(2023, 5, 27),
        start: const TimeOfDay(hour: 16, minute: 0),
        end: const TimeOfDay(hour: 20, minute: 0),
        address: '4358 Progress Way, Hutchinson, MN',
        child: const Child(
          cid: 'phualvrfxVOBWQlEm9',
          name: 'Inés Mendes',
          picture: 'assets/images/ines-mendes.jpg',
          age: 7,
          parentId: 'gXQdXPnwmDo7m76JJh',
        ),
      ),
    ],
    'clients': <Client>[
      Parent(
        cid: 'lQIvS2Rw3PdaWEhA4a',
        name: 'Ana Carvalho',
        picture: 'assets/images/ana-carvalho.jpg',
        phone: '+351987654321',
        address: '2726 Colony Street, Stamford, CT',
        messages: <Message>[
          Message(
            id: 'lQIvS2Rw3PdaWEhA4a',
            dateTime: DateTime.utc(2023, 5, 12, 19, 30),
            content: 'Hey! Thank you for taking care of her.',
          ),
          Message(
            id: '',
            dateTime: DateTime.utc(2023, 5, 12, 19, 39),
            content: 'No problem!',
          ),
        ],
      ),
      Parent(
        cid: 'gXQdXPnwmDo7m76JJh',
        name: 'João and Paula Mendes',
        picture: 'assets/images/joao-mendes.jpg',
        phone: '+351876543210',
        address: '4358 Progress Way, Hutchinson, MN',
        messages: [
          Message(
            id: 'gXQdXPnwmDo7m76JJh',
            dateTime: DateTime.utc(2023, 5, 15, 10, 24),
            content: 'Good morning,\nAnything else that you like to know?',
          ),
        ],
      ),
      Child(
        cid: 'NSh79WPgYm4I14kGP9',
        name: 'Pedro Carvalho',
        picture: 'assets/images/pedro-carvalho.jpg',
        age: 8,
        parentId: 'lQIvS2Rw3PdaWEhA4a',
        informations: <Information>[
          Information(
            icon: Icons.dinner_dining,
            title: 'Favorite meals',
            items: <String, String?>{
              'Pancakes': 'With Nutella and Banana.',
            },
          ),
          Information(
            icon: Icons.directions_run,
            title: 'Favorite activities',
            items: <String, String?>{
              'Playing videogame': 'Like to play Fortnite',
              'Soccer': 'Prefer playing as goalkeeper',
            },
          ),
        ],
      ),
      Child(
        cid: 'ezHNYJ5z7AwTBJndnt',
        name: 'Maria Carvalho',
        picture: 'assets/images/maria-carvalho.jpg',
        age: 5,
        parentId: 'lQIvS2Rw3PdaWEhA4a',
        informations: <Information>[
          Information(
            icon: Icons.sick,
            title: 'Alergies',
            items: <String, String?>{
              'Peanuts': null,
              'Cats': 'Don\'t let her play with the house pet'
            },
          ),
          Information(
            icon: Icons.directions_run,
            title: 'Favorite activities',
            items: <String, String?>{
              'Hide and Seed': 'She always hides under her mother\' bed',
            },
          ),
        ],
      ),
      Child(
        cid: 'phualvrfxVOBWQlEm9',
        name: 'Inés Mendes',
        picture: 'assets/images/ines-mendes.jpg',
        age: 7,
        parentId: 'gXQdXPnwmDo7m76JJh',
        informations: <Information>[
          Information(
            icon: Icons.directions_run,
            title: 'Favorite activities',
            items: <String, String?>{
              'Indoor activities': 'She doesn\' like to play outside',
            },
          ),
        ],
      ),
    ],
  };

  @override
  List<T> get<T extends Model>(String bucket) {
    return _storage[bucket]!.cast<T>();
  }

  @override
  void add<T extends Model>(String bucket, T value) {
    _storage[bucket]?.add(value);
  }
}
