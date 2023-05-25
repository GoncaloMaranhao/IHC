library login_route;

import 'package:flutter/foundation.dart';
import 'package:flutter/material.dart';
import 'package:go_router/go_router.dart';
import 'package:provider/provider.dart';

import '../../providers/providers.dart';

part 'form.dart';

class LogInScreen extends StatelessWidget {
  const LogInScreen({super.key});

  @override
  Widget build(BuildContext context) {
    final theme = Theme.of(context);
    return Scaffold(
      body: SafeArea(
        child: SingleChildScrollView(
          physics: const NeverScrollableScrollPhysics(),
          reverse: true,
          child: Column(
            children: const <Widget>[
              Padding(
                padding: EdgeInsets.only(
                  top: 102.0,
                  bottom: 80.0,
                ),
                child: Text(
                  'Welcome to Babysit Ease',
                  textAlign: TextAlign.center,
                  style: TextStyle(
                    fontSize: 50,
                    fontWeight: FontWeight.w500,
                  ),
                ),
              ),
              LogInForm()
            ],
          ),
        ),
      ),
    );
  }
}
