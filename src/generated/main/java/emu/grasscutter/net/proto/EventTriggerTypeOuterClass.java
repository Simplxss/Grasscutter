// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: EventTriggerType.proto

package emu.grasscutter.net.proto;

public final class EventTriggerTypeOuterClass {
  private EventTriggerTypeOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  /**
   * Protobuf enum {@code EventTriggerType}
   */
  public enum EventTriggerType
      implements com.google.protobuf.ProtocolMessageEnum {
    /**
     * <code>EVENT_TRIGGER_TYPE_NONE = 0;</code>
     */
    EVENT_TRIGGER_TYPE_NONE(0),
    /**
     * <code>EVENT_TRIGGER_TYPE_ENTER_FORCE = 1;</code>
     */
    EVENT_TRIGGER_TYPE_ENTER_FORCE(1),
    UNRECOGNIZED(-1),
    ;

    /**
     * <code>EVENT_TRIGGER_TYPE_NONE = 0;</code>
     */
    public static final int EVENT_TRIGGER_TYPE_NONE_VALUE = 0;
    /**
     * <code>EVENT_TRIGGER_TYPE_ENTER_FORCE = 1;</code>
     */
    public static final int EVENT_TRIGGER_TYPE_ENTER_FORCE_VALUE = 1;


    public final int getNumber() {
      if (this == UNRECOGNIZED) {
        throw new java.lang.IllegalArgumentException(
            "Can't get the number of an unknown enum value.");
      }
      return value;
    }

    /**
     * @param value The numeric wire value of the corresponding enum entry.
     * @return The enum associated with the given numeric wire value.
     * @deprecated Use {@link #forNumber(int)} instead.
     */
    @java.lang.Deprecated
    public static EventTriggerType valueOf(int value) {
      return forNumber(value);
    }

    /**
     * @param value The numeric wire value of the corresponding enum entry.
     * @return The enum associated with the given numeric wire value.
     */
    public static EventTriggerType forNumber(int value) {
      switch (value) {
        case 0: return EVENT_TRIGGER_TYPE_NONE;
        case 1: return EVENT_TRIGGER_TYPE_ENTER_FORCE;
        default: return null;
      }
    }

    public static com.google.protobuf.Internal.EnumLiteMap<EventTriggerType>
        internalGetValueMap() {
      return internalValueMap;
    }
    private static final com.google.protobuf.Internal.EnumLiteMap<
        EventTriggerType> internalValueMap =
          new com.google.protobuf.Internal.EnumLiteMap<EventTriggerType>() {
            public EventTriggerType findValueByNumber(int number) {
              return EventTriggerType.forNumber(number);
            }
          };

    public final com.google.protobuf.Descriptors.EnumValueDescriptor
        getValueDescriptor() {
      if (this == UNRECOGNIZED) {
        throw new java.lang.IllegalStateException(
            "Can't get the descriptor of an unrecognized enum value.");
      }
      return getDescriptor().getValues().get(ordinal());
    }
    public final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptorForType() {
      return getDescriptor();
    }
    public static final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptor() {
      return emu.grasscutter.net.proto.EventTriggerTypeOuterClass.getDescriptor().getEnumTypes().get(0);
    }

    private static final EventTriggerType[] VALUES = values();

    public static EventTriggerType valueOf(
        com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
      if (desc.getType() != getDescriptor()) {
        throw new java.lang.IllegalArgumentException(
          "EnumValueDescriptor is not for this type.");
      }
      if (desc.getIndex() == -1) {
        return UNRECOGNIZED;
      }
      return VALUES[desc.getIndex()];
    }

    private final int value;

    private EventTriggerType(int value) {
      this.value = value;
    }

    // @@protoc_insertion_point(enum_scope:EventTriggerType)
  }


  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\026EventTriggerType.proto*S\n\020EventTrigger" +
      "Type\022\033\n\027EVENT_TRIGGER_TYPE_NONE\020\000\022\"\n\036EVE" +
      "NT_TRIGGER_TYPE_ENTER_FORCE\020\001B\033\n\031emu.gra" +
      "sscutter.net.protob\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
