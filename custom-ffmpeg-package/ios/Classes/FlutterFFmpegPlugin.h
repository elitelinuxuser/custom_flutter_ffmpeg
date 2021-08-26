#import <Flutter/Flutter.h>
#import <mobileffmpeg/MobileFFmpegConfig.h>

/**
 * Flutter FFmpeg Plugin
 */
@interface FlutterFFmpegPlugin : NSObject<FlutterPlugin,FlutterStreamHandler,LogDelegate,StatisticsDelegate>
@end
