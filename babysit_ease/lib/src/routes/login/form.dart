part of login_route;

class LogInForm extends StatefulWidget {
  const LogInForm({super.key});

  @override
  State<LogInForm> createState() => _LogInFormState();
}

class _LogInFormState extends State<LogInForm> {

  final formKey = GlobalKey<FormState>();

  late TextEditingController emailController;
  late TextEditingController passwordController;

  @override
  void initState() {
    super.initState();
    emailController = TextEditingController();
    passwordController = TextEditingController();
  }

  @override
  void dispose() {
    super.dispose();
    emailController.dispose();
    passwordController.dispose();
  }

  @override
  Widget build(BuildContext context) {
    final theme = Theme.of(context);
    final auth = context.read<AuthController>();
    return Form(
      key: formKey,
      child: Padding(
        padding: const EdgeInsets.all(28.0),
        child: Column(
          children: <Widget>[
            TextFormField(
              controller: emailController,
              keyboardType: TextInputType.emailAddress,
              textInputAction: TextInputAction.next,
              cursorColor: theme.primaryColor,
              validator: (value) {
                if (value == null || value.isEmpty) {
                  return 'Please, enter your email';
                } else if (!value.contains('@')) {
                  return 'Please, enter a valid email';
                }
                return null;
              },
              decoration: const InputDecoration(
                label: Text('Email'),
                hintText: 'youremail@email.com',
                prefixIcon: Icon(Icons.email_outlined),
                border: OutlineInputBorder(),
              ),
            ),
            const SizedBox(height: 28.0),
            TextFormField(
              controller: passwordController,
              keyboardType: TextInputType.visiblePassword,
              textInputAction: TextInputAction.next,
              cursorColor: theme.primaryColor,
              obscureText: true,
              validator: (value) {
                if (value == null || value.isEmpty) {
                  return 'Please, enter your password';
                }
                return null;
              },
              decoration: const InputDecoration(
                label: Text('Password'),
                prefixIcon: Icon(Icons.password),
                border: OutlineInputBorder(),
              ),
            ),
            const SizedBox(height: 26.0),
            const Text('Forgot password?'),
            const SizedBox(height: 24.0),
            ButtonTheme(
              textTheme: ButtonTextTheme.primary,
              height: 100.0,
              minWidth: 300.0,
              child: FractionallySizedBox(
                widthFactor: 1,
                child: FilledButton(
                  onPressed: () {
                    if (!formKey.currentState!.validate()) {
                      return;
                    }
                    final user = auth.loginWithEmailAndPassword(
                      email: emailController.text,
                      password: passwordController.text,
                    );
                    if (user != null) {
                      context.push('/');
                      return;
                    }
                    ScaffoldMessenger.of(context).showSnackBar(
                      const SnackBar(content: Text('Invalid email or password!')),
                    );
                  },
                  child: const Text('Log In', style: TextStyle(fontSize: 20),),
                ),
              ),
            ),
          ],
        ),
      ),
    );
  }
}
