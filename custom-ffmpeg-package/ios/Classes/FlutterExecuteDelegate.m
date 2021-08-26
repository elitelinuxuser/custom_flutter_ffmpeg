#import "FlutterExecuteDelegate.h"

static NSString *const EVENT_EXECUTE = @"FlutterFFmpegExecuteCallback";

/**
 * Execute delegate for async executions.
 */
@implementation FlutterExecuteDelegate {
    FlutterEventSink _eventSink;
}

- (instancetype)initWithEventSink:(FlutterEventSink)eventSink {
    self = [super init];
    if (self) {
        _eventSink = eventSink;
    }

    return self;
}

- (void)executeCallback:(long)executionId :(int)returnCode {
    NSMutableDictionary *executeDictionary = [[NSMutableDictionary alloc] init];
    executeDictionary[@"executionId"] = [NSNumber numberWithLong: executionId];
    executeDictionary[@"returnCode"] = [NSNumber numberWithInt: returnCode];

    NSMutableDictionary *eventDictionary = [[NSMutableDictionary alloc] init];
    eventDictionary[EVENT_EXECUTE] = executeDictionary;

    _eventSink(eventDictionary);
}

@end
