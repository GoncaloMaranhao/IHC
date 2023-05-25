
import 'package:flutter/material.dart';
import 'package:provider/provider.dart';

import 'providers/providers.dart';
import 'routes/routes.dart';

/// The BabysitEase App entry Widget.
///
/// A widget that wraps the game application. Built upon [MaterialApp].
class App extends StatelessWidget {
  /// Creates an [App].
  const App({
    super.key,
    this.showPerformanceOverlay = false,
    this.checkerboardRasterCacheImages = false,
    this.checkerboardOffscreenLayers = false,
    this.showSemanticsDebugger = false,
    this.debugShowCheckedModeBanner = true,
    this.restorationScopeId,
    this.debugShowMaterialGrid = false,
    this.useInheritedMediaQuery = false,
  });

  /// Turns on a performance overlay.
  ///
  /// See also:
  ///
  ///  * <https://flutter.dev/debugging/#performance-overlay>
  final bool showPerformanceOverlay;

  /// Turns on checkerboarding of raster cache images.
  final bool checkerboardRasterCacheImages;

  /// Turns on checkerboarding of layers rendered to offscreen bitmaps.
  final bool checkerboardOffscreenLayers;

  /// Turns on an overlay that shows the accessibility information
  /// reported by the framework.
  final bool showSemanticsDebugger;

  /// {@macro flutter.widgets.widgetsApp.debugShowCheckedModeBanner}
  final bool debugShowCheckedModeBanner;

  /// {@macro flutter.widgets.widgetsApp.restorationScopeId}
  final String? restorationScopeId;

  /// Turns on a [GridPaper] overlay that paints a baseline grid
  /// Material apps.
  ///
  /// Only available in debug mode.
  ///
  /// See also:
  ///
  ///  * <https://material.io/design/layout/spacing-methods.html>
  final bool debugShowMaterialGrid;

  /// {@macro flutter.widgets.widgetsApp.useInheritedMediaQuery}
  final bool useInheritedMediaQuery;

  @override
  Widget build(BuildContext context) {
    return MultiProvider(
      providers: providers,
      child: MaterialApp.router(
        // key: ,
        // scaffoldMessengerKey: ,
        // routeInformationProvider: ,
        // routeInformationParser: ,
        // routerDelegate: ,
        routerConfig: AppRouter(
          // redirectLimit: ,
          // routerNeglect: ,
          // initialExtra: ,
          // observers: ,
          // debugLogDiagnostics: ,
          // navigatorKey: ,
          // restorationScopeId: ,
        ),
        // backButtonDispatcher: ,
        // builder: ,
        title: 'Babysit Ease',
        // onGenerateTitle: ,
        // color: ,
        theme: ThemeData.from(
          colorScheme: ColorScheme.fromSeed(
            seedColor: Colors.deepPurple,
            brightness: Brightness.light,
          ),
          useMaterial3: true,
        ),
        darkTheme: ThemeData.from(
          colorScheme: ColorScheme.fromSeed(
            seedColor: Colors.deepPurple,
            brightness: Brightness.dark,
          ),
          useMaterial3: true,
        ),
        // highContrastTheme: ,
        // highContrastDarkTheme: ,
        // themeMode: ,
        // themeAnimationDuration: ,
        // themeAnimationCurve: ,
        // locale: ,
        // localizationsDelegates: ,
        // localeListResolutionCallback: ,
        // localeResolutionCallback: ,
        // supportedLocales: ,
        debugShowMaterialGrid: debugShowMaterialGrid,
        showPerformanceOverlay: showPerformanceOverlay,
        checkerboardRasterCacheImages: checkerboardRasterCacheImages,
        checkerboardOffscreenLayers: checkerboardOffscreenLayers,
        showSemanticsDebugger: showSemanticsDebugger,
        debugShowCheckedModeBanner: debugShowCheckedModeBanner,
        // shortcuts: ,
        // actions: ,
        restorationScopeId: restorationScopeId,
        // scrollBehavior: ,
        useInheritedMediaQuery: useInheritedMediaQuery,
      ),
    );
  }
}
