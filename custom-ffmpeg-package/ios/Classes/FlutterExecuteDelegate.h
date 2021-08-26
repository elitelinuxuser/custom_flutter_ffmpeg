#import <Flutter/Flutter.h>
#import <mobileffmpeg/ExecuteDelegate.h>

/**
 * Execute delegate for async executions.
 */
@interface FlutterExecuteDelegate : NSObject<ExecuteDelegate>

- (instancetype)initWithEventSink:(FlutterEventSink)eventSink;

@end
