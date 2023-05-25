part of providers;

class AuthController {
  AuthController(this._storage);

  final Storage _storage;

  User? _current;
  User? get current => _current;

  User? loginWithEmailAndPassword({
    required String email,
    required String password,
  }) {
    final user = _storage.get<User>('users').first;
    if (user.email == email && user.password == password) {
      _current = user;
    }
    return _current;
  }

  void logout() {
    _current = null;
  }
}

class AppointmentsController {
  AppointmentsController(this._storage);

  final Storage _storage;

  List<Appointment> fetchToday(DateTime day) {
    final appointments = _storage.get<Appointment>('appointments');
    return appointments.where((a) => a.date == day).toList();
  }

  bool add({
    required String title,
    required DateTime date,
    required TimeOfDay start,
    required TimeOfDay end,
    required Child child,
  }) {
      final parent = _storage
        .get<Client>('clients')
        .whereType<Parent>()
        .where((p) => p.cid == child.parentId).first;

    _storage.add('appointments', Appointment(
      title: title,
      date: DateTime.utc(date.year, date.month, date.day),
      start: start,
      end: end,
      child: child,
      address: parent.address,
    ));

    return true;
  }
}

class ClientsController {
  ClientsController(this._storage);

  final Storage _storage;

  List<T> getAll<T extends Client>([String? cid]) {
    var iter = _storage.get<Client>('clients').whereType<T>();
    if (cid != null) {
      iter = iter.where((c) => c.cid == cid);
    }
    return iter.toList();
  }

  Parent getParent(String cid) {
    return getAll<Parent>().where((p) => p.cid == cid).first;
  }

}
