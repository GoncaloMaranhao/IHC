
import 'package:flutter/foundation.dart';
import 'package:flutter/material.dart';
import 'package:logging/logging.dart';

import 'src/app.dart';

void main() {
  WidgetsFlutterBinding.ensureInitialized();

  if (kDebugMode) {
    Logger.root.level = Level.FINE;
  }

  Logger.root.onRecord.listen((record) {
    final message = '${record.level.name}: ${record.time}: '
        '${record.loggerName}: '
        '${record.message}';

    debugPrint(message);
  });

  runApp(
    const App(
      // showPerformanceOverlay: ,
      // checkerboardRasterCacheImages: ,
      // checkerboardOffscreenLayers: ,
      // showSemanticsDebugger: ,
      debugShowCheckedModeBanner: false,
      // restorationScopeId: ,
      // debugShowMaterialGrid: ,
      // useInheritedMediaQuery: ,
    ),
  );
}
