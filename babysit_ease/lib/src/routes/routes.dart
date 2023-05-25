
import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';
import 'package:provider/provider.dart';

import '../providers/providers.dart';

import 'appointment/appointment.dart';
import 'clients/clients.dart';
import 'home/home.dart';
import 'login/login.dart';
import 'messages/messages.dart';

/// The application router.
///
/// The [AppRouter] is a subclass of [GoRouter] so it can be passed as
/// [routerConfig] to any subclass of [WidgetsApp.router].
class AppRouter extends GoRouter {
  /// Default constructor to configure the router.
  AppRouter({
    int redirectLimit = 5,
    bool routerNeglect = false,
    Object? initialExtra,
    List<NavigatorObserver>? observers,
    bool debugLogDiagnostics = false,
    GlobalKey<NavigatorState>? navigatorKey,
    String? restorationScopeId,
  }) : super(
    routes: routes,
    // errorPageBuilder: ,
    // errorBuilder: ,
    redirect: (context, _) {
      final auth = context.read<AuthController>();
      if (auth.current != null) {
        return null;
      }
      return '/login';
    },
    // refreshListenable: ,
    redirectLimit: redirectLimit,
    routerNeglect: routerNeglect,
    // initialLocation: ,
    initialExtra: initialExtra,
    observers: observers,
    debugLogDiagnostics: debugLogDiagnostics,
    navigatorKey: navigatorKey,
    restorationScopeId: restorationScopeId,
  );

  /// The routes for this app.
  static List<GoRoute> get routes => <GoRoute>[
    GoRoute(
      path: '/',
      builder: (context, state) =>
          const HomeScreen(key: Key('home')),
      routes: <GoRoute>[
        // Appointment Routes:
        GoRoute(
          path: 'appointment/add',
          builder: (context, state) {
            DateTime? selectedDay = state.extra as DateTime?;
            return AppointmentScreen.add(
              key: const Key('add appointment'),
              selectedDay: selectedDay,
            );
          },
        ),
        // Clients Routes:
        GoRoute(
          path: 'clients',
          builder: (context, state) =>
              const ClientsScreen.all(key: Key('clients')),
          routes: <GoRoute>[
            GoRoute(
              path: ':cid',
              builder: (context, state) {
                final clientId = state.pathParameters['cid']!;
                return ClientsScreen.detail(
                  key: Key('clients $clientId'),
                  clientId: clientId,
                );
              },
            ),
          ],
        ),
        // Login Routes:
        GoRoute(
          path: 'login',
          builder: (context, state) =>
              const LogInScreen(key: Key('login')),
        ),
        // Messages Routes:
        GoRoute(
          path: 'messages',
          builder: (context, state) =>
              const MessagesScreen.all(key: Key('messages')),
          routes: <GoRoute>[
            GoRoute(
              path: ':cid',
              builder: (context, state) {
                final clientId = state.pathParameters['cid']!;
                return MessagesScreen.conversation(
                  key: Key('messages $clientId'),
                  clientId: clientId,
                );
              }
            ),
          ],
        ),
      ],
    ),
  ];
}
