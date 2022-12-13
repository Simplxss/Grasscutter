// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: HideAndSeekStageType.proto

package emu.grasscutter.net.proto;

public final class HideAndSeekStageTypeOuterClass {
  private HideAndSeekStageTypeOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  /**
   * Protobuf enum {@code HideAndSeekStageType}
   */
  public enum HideAndSeekStageType
      implements com.google.protobuf.ProtocolMessageEnum {
    /**
     * <code>HIDE_AND_SEEK_STAGE_TYPE_PREPARE = 0;</code>
     */
    HIDE_AND_SEEK_STAGE_TYPE_PREPARE(0),
    /**
     * <code>HIDE_AND_SEEK_STAGE_TYPE_PICK = 1;</code>
     */
    HIDE_AND_SEEK_STAGE_TYPE_PICK(1),
    /**
     * <code>HIDE_AND_SEEK_STAGE_TYPE_GAME = 2;</code>
     */
    HIDE_AND_SEEK_STAGE_TYPE_GAME(2),
    /**
     * <code>HIDE_AND_SEEK_STAGE_TYPE_HIDE = 3;</code>
     */
    HIDE_AND_SEEK_STAGE_TYPE_HIDE(3),
    /**
     * <code>HIDE_AND_SEEK_STAGE_TYPE_SEEK = 4;</code>
     */
    HIDE_AND_SEEK_STAGE_TYPE_SEEK(4),
    /**
     * <code>HIDE_AND_SEEK_STAGE_TYPE_SETTLE = 5;</code>
     */
    HIDE_AND_SEEK_STAGE_TYPE_SETTLE(5),
    UNRECOGNIZED(-1),
    ;

    /**
     * <code>HIDE_AND_SEEK_STAGE_TYPE_PREPARE = 0;</code>
     */
    public static final int HIDE_AND_SEEK_STAGE_TYPE_PREPARE_VALUE = 0;
    /**
     * <code>HIDE_AND_SEEK_STAGE_TYPE_PICK = 1;</code>
     */
    public static final int HIDE_AND_SEEK_STAGE_TYPE_PICK_VALUE = 1;
    /**
     * <code>HIDE_AND_SEEK_STAGE_TYPE_GAME = 2;</code>
     */
    public static final int HIDE_AND_SEEK_STAGE_TYPE_GAME_VALUE = 2;
    /**
     * <code>HIDE_AND_SEEK_STAGE_TYPE_HIDE = 3;</code>
     */
    public static final int HIDE_AND_SEEK_STAGE_TYPE_HIDE_VALUE = 3;
    /**
     * <code>HIDE_AND_SEEK_STAGE_TYPE_SEEK = 4;</code>
     */
    public static final int HIDE_AND_SEEK_STAGE_TYPE_SEEK_VALUE = 4;
    /**
     * <code>HIDE_AND_SEEK_STAGE_TYPE_SETTLE = 5;</code>
     */
    public static final int HIDE_AND_SEEK_STAGE_TYPE_SETTLE_VALUE = 5;


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
    public static HideAndSeekStageType valueOf(int value) {
      return forNumber(value);
    }

    /**
     * @param value The numeric wire value of the corresponding enum entry.
     * @return The enum associated with the given numeric wire value.
     */
    public static HideAndSeekStageType forNumber(int value) {
      switch (value) {
        case 0: return HIDE_AND_SEEK_STAGE_TYPE_PREPARE;
        case 1: return HIDE_AND_SEEK_STAGE_TYPE_PICK;
        case 2: return HIDE_AND_SEEK_STAGE_TYPE_GAME;
        case 3: return HIDE_AND_SEEK_STAGE_TYPE_HIDE;
        case 4: return HIDE_AND_SEEK_STAGE_TYPE_SEEK;
        case 5: return HIDE_AND_SEEK_STAGE_TYPE_SETTLE;
        default: return null;
      }
    }

    public static com.google.protobuf.Internal.EnumLiteMap<HideAndSeekStageType>
        internalGetValueMap() {
      return internalValueMap;
    }
    private static final com.google.protobuf.Internal.EnumLiteMap<
        HideAndSeekStageType> internalValueMap =
          new com.google.protobuf.Internal.EnumLiteMap<HideAndSeekStageType>() {
            public HideAndSeekStageType findValueByNumber(int number) {
              return HideAndSeekStageType.forNumber(number);
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
      return emu.grasscutter.net.proto.HideAndSeekStageTypeOuterClass.getDescriptor().getEnumTypes().get(0);
    }

    private static final HideAndSeekStageType[] VALUES = values();

    public static HideAndSeekStageType valueOf(
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

    private HideAndSeekStageType(int value) {
      this.value = value;
    }

    // @@protoc_insertion_point(enum_scope:HideAndSeekStageType)
  }


  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\032HideAndSeekStageType.proto*\355\001\n\024HideAnd" +
      "SeekStageType\022$\n HIDE_AND_SEEK_STAGE_TYP" +
      "E_PREPARE\020\000\022!\n\035HIDE_AND_SEEK_STAGE_TYPE_" +
      "PICK\020\001\022!\n\035HIDE_AND_SEEK_STAGE_TYPE_GAME\020" +
      "\002\022!\n\035HIDE_AND_SEEK_STAGE_TYPE_HIDE\020\003\022!\n\035" +
      "HIDE_AND_SEEK_STAGE_TYPE_SEEK\020\004\022#\n\037HIDE_" +
      "AND_SEEK_STAGE_TYPE_SETTLE\020\005B\033\n\031emu.gras" +
      "scutter.net.protob\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
  }

  // @@protoc_insertion_point(outer_class_scope)
}