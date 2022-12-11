// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ScenePlayOwnerCheckReq.proto

package emu.grasscutter.net.proto;

public final class ScenePlayOwnerCheckReqOuterClass {
  private ScenePlayOwnerCheckReqOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface ScenePlayOwnerCheckReqOrBuilder extends
      // @@protoc_insertion_point(interface_extends:ScenePlayOwnerCheckReq)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>uint32 play_id = 10;</code>
     * @return The playId.
     */
    int getPlayId();

    /**
     * <code>bool is_skip_match = 8;</code>
     * @return The isSkipMatch.
     */
    boolean getIsSkipMatch();
  }
  /**
   * <pre>
   * enum CmdId {
   *   option allow_alias = true;
   *   NONE = 0;
   *   CMD_ID = 4380;
   *   ENET_CHANNEL_ID = 0;
   *   ENET_IS_RELIABLE = 1;
   *   IS_ALLOW_CLIENT = 1;
   * }
   * </pre>
   *
   * Protobuf type {@code ScenePlayOwnerCheckReq}
   */
  public static final class ScenePlayOwnerCheckReq extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:ScenePlayOwnerCheckReq)
      ScenePlayOwnerCheckReqOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use ScenePlayOwnerCheckReq.newBuilder() to construct.
    private ScenePlayOwnerCheckReq(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private ScenePlayOwnerCheckReq() {
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(
        UnusedPrivateParameter unused) {
      return new ScenePlayOwnerCheckReq();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private ScenePlayOwnerCheckReq(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder();
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 64: {

              isSkipMatch_ = input.readBool();
              break;
            }
            case 80: {

              playId_ = input.readUInt32();
              break;
            }
            default: {
              if (!parseUnknownField(
                  input, unknownFields, extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e).setUnfinishedMessage(this);
      } finally {
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return emu.grasscutter.net.proto.ScenePlayOwnerCheckReqOuterClass.internal_static_ScenePlayOwnerCheckReq_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return emu.grasscutter.net.proto.ScenePlayOwnerCheckReqOuterClass.internal_static_ScenePlayOwnerCheckReq_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              emu.grasscutter.net.proto.ScenePlayOwnerCheckReqOuterClass.ScenePlayOwnerCheckReq.class, emu.grasscutter.net.proto.ScenePlayOwnerCheckReqOuterClass.ScenePlayOwnerCheckReq.Builder.class);
    }

    public static final int PLAY_ID_FIELD_NUMBER = 10;
    private int playId_;
    /**
     * <code>uint32 play_id = 10;</code>
     * @return The playId.
     */
    @java.lang.Override
    public int getPlayId() {
      return playId_;
    }

    public static final int IS_SKIP_MATCH_FIELD_NUMBER = 8;
    private boolean isSkipMatch_;
    /**
     * <code>bool is_skip_match = 8;</code>
     * @return The isSkipMatch.
     */
    @java.lang.Override
    public boolean getIsSkipMatch() {
      return isSkipMatch_;
    }

    private byte memoizedIsInitialized = -1;
    @java.lang.Override
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    @java.lang.Override
    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (isSkipMatch_ != false) {
        output.writeBool(8, isSkipMatch_);
      }
      if (playId_ != 0) {
        output.writeUInt32(10, playId_);
      }
      unknownFields.writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (isSkipMatch_ != false) {
        size += com.google.protobuf.CodedOutputStream
          .computeBoolSize(8, isSkipMatch_);
      }
      if (playId_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeUInt32Size(10, playId_);
      }
      size += unknownFields.getSerializedSize();
      memoizedSize = size;
      return size;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof emu.grasscutter.net.proto.ScenePlayOwnerCheckReqOuterClass.ScenePlayOwnerCheckReq)) {
        return super.equals(obj);
      }
      emu.grasscutter.net.proto.ScenePlayOwnerCheckReqOuterClass.ScenePlayOwnerCheckReq other = (emu.grasscutter.net.proto.ScenePlayOwnerCheckReqOuterClass.ScenePlayOwnerCheckReq) obj;

      if (getPlayId()
          != other.getPlayId()) return false;
      if (getIsSkipMatch()
          != other.getIsSkipMatch()) return false;
      if (!unknownFields.equals(other.unknownFields)) return false;
      return true;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptor().hashCode();
      hash = (37 * hash) + PLAY_ID_FIELD_NUMBER;
      hash = (53 * hash) + getPlayId();
      hash = (37 * hash) + IS_SKIP_MATCH_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
          getIsSkipMatch());
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static emu.grasscutter.net.proto.ScenePlayOwnerCheckReqOuterClass.ScenePlayOwnerCheckReq parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static emu.grasscutter.net.proto.ScenePlayOwnerCheckReqOuterClass.ScenePlayOwnerCheckReq parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static emu.grasscutter.net.proto.ScenePlayOwnerCheckReqOuterClass.ScenePlayOwnerCheckReq parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static emu.grasscutter.net.proto.ScenePlayOwnerCheckReqOuterClass.ScenePlayOwnerCheckReq parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static emu.grasscutter.net.proto.ScenePlayOwnerCheckReqOuterClass.ScenePlayOwnerCheckReq parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static emu.grasscutter.net.proto.ScenePlayOwnerCheckReqOuterClass.ScenePlayOwnerCheckReq parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static emu.grasscutter.net.proto.ScenePlayOwnerCheckReqOuterClass.ScenePlayOwnerCheckReq parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static emu.grasscutter.net.proto.ScenePlayOwnerCheckReqOuterClass.ScenePlayOwnerCheckReq parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static emu.grasscutter.net.proto.ScenePlayOwnerCheckReqOuterClass.ScenePlayOwnerCheckReq parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static emu.grasscutter.net.proto.ScenePlayOwnerCheckReqOuterClass.ScenePlayOwnerCheckReq parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static emu.grasscutter.net.proto.ScenePlayOwnerCheckReqOuterClass.ScenePlayOwnerCheckReq parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static emu.grasscutter.net.proto.ScenePlayOwnerCheckReqOuterClass.ScenePlayOwnerCheckReq parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    @java.lang.Override
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(emu.grasscutter.net.proto.ScenePlayOwnerCheckReqOuterClass.ScenePlayOwnerCheckReq prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    @java.lang.Override
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * <pre>
     * enum CmdId {
     *   option allow_alias = true;
     *   NONE = 0;
     *   CMD_ID = 4380;
     *   ENET_CHANNEL_ID = 0;
     *   ENET_IS_RELIABLE = 1;
     *   IS_ALLOW_CLIENT = 1;
     * }
     * </pre>
     *
     * Protobuf type {@code ScenePlayOwnerCheckReq}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:ScenePlayOwnerCheckReq)
        emu.grasscutter.net.proto.ScenePlayOwnerCheckReqOuterClass.ScenePlayOwnerCheckReqOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return emu.grasscutter.net.proto.ScenePlayOwnerCheckReqOuterClass.internal_static_ScenePlayOwnerCheckReq_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return emu.grasscutter.net.proto.ScenePlayOwnerCheckReqOuterClass.internal_static_ScenePlayOwnerCheckReq_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                emu.grasscutter.net.proto.ScenePlayOwnerCheckReqOuterClass.ScenePlayOwnerCheckReq.class, emu.grasscutter.net.proto.ScenePlayOwnerCheckReqOuterClass.ScenePlayOwnerCheckReq.Builder.class);
      }

      // Construct using emu.grasscutter.net.proto.ScenePlayOwnerCheckReqOuterClass.ScenePlayOwnerCheckReq.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3
                .alwaysUseFieldBuilders) {
        }
      }
      @java.lang.Override
      public Builder clear() {
        super.clear();
        playId_ = 0;

        isSkipMatch_ = false;

        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return emu.grasscutter.net.proto.ScenePlayOwnerCheckReqOuterClass.internal_static_ScenePlayOwnerCheckReq_descriptor;
      }

      @java.lang.Override
      public emu.grasscutter.net.proto.ScenePlayOwnerCheckReqOuterClass.ScenePlayOwnerCheckReq getDefaultInstanceForType() {
        return emu.grasscutter.net.proto.ScenePlayOwnerCheckReqOuterClass.ScenePlayOwnerCheckReq.getDefaultInstance();
      }

      @java.lang.Override
      public emu.grasscutter.net.proto.ScenePlayOwnerCheckReqOuterClass.ScenePlayOwnerCheckReq build() {
        emu.grasscutter.net.proto.ScenePlayOwnerCheckReqOuterClass.ScenePlayOwnerCheckReq result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public emu.grasscutter.net.proto.ScenePlayOwnerCheckReqOuterClass.ScenePlayOwnerCheckReq buildPartial() {
        emu.grasscutter.net.proto.ScenePlayOwnerCheckReqOuterClass.ScenePlayOwnerCheckReq result = new emu.grasscutter.net.proto.ScenePlayOwnerCheckReqOuterClass.ScenePlayOwnerCheckReq(this);
        result.playId_ = playId_;
        result.isSkipMatch_ = isSkipMatch_;
        onBuilt();
        return result;
      }

      @java.lang.Override
      public Builder clone() {
        return super.clone();
      }
      @java.lang.Override
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return super.setField(field, value);
      }
      @java.lang.Override
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return super.clearField(field);
      }
      @java.lang.Override
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return super.clearOneof(oneof);
      }
      @java.lang.Override
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, java.lang.Object value) {
        return super.setRepeatedField(field, index, value);
      }
      @java.lang.Override
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return super.addRepeatedField(field, value);
      }
      @java.lang.Override
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof emu.grasscutter.net.proto.ScenePlayOwnerCheckReqOuterClass.ScenePlayOwnerCheckReq) {
          return mergeFrom((emu.grasscutter.net.proto.ScenePlayOwnerCheckReqOuterClass.ScenePlayOwnerCheckReq)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(emu.grasscutter.net.proto.ScenePlayOwnerCheckReqOuterClass.ScenePlayOwnerCheckReq other) {
        if (other == emu.grasscutter.net.proto.ScenePlayOwnerCheckReqOuterClass.ScenePlayOwnerCheckReq.getDefaultInstance()) return this;
        if (other.getPlayId() != 0) {
          setPlayId(other.getPlayId());
        }
        if (other.getIsSkipMatch() != false) {
          setIsSkipMatch(other.getIsSkipMatch());
        }
        this.mergeUnknownFields(other.unknownFields);
        onChanged();
        return this;
      }

      @java.lang.Override
      public final boolean isInitialized() {
        return true;
      }

      @java.lang.Override
      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        emu.grasscutter.net.proto.ScenePlayOwnerCheckReqOuterClass.ScenePlayOwnerCheckReq parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (emu.grasscutter.net.proto.ScenePlayOwnerCheckReqOuterClass.ScenePlayOwnerCheckReq) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private int playId_ ;
      /**
       * <code>uint32 play_id = 10;</code>
       * @return The playId.
       */
      @java.lang.Override
      public int getPlayId() {
        return playId_;
      }
      /**
       * <code>uint32 play_id = 10;</code>
       * @param value The playId to set.
       * @return This builder for chaining.
       */
      public Builder setPlayId(int value) {
        
        playId_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>uint32 play_id = 10;</code>
       * @return This builder for chaining.
       */
      public Builder clearPlayId() {
        
        playId_ = 0;
        onChanged();
        return this;
      }

      private boolean isSkipMatch_ ;
      /**
       * <code>bool is_skip_match = 8;</code>
       * @return The isSkipMatch.
       */
      @java.lang.Override
      public boolean getIsSkipMatch() {
        return isSkipMatch_;
      }
      /**
       * <code>bool is_skip_match = 8;</code>
       * @param value The isSkipMatch to set.
       * @return This builder for chaining.
       */
      public Builder setIsSkipMatch(boolean value) {
        
        isSkipMatch_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>bool is_skip_match = 8;</code>
       * @return This builder for chaining.
       */
      public Builder clearIsSkipMatch() {
        
        isSkipMatch_ = false;
        onChanged();
        return this;
      }
      @java.lang.Override
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.setUnknownFields(unknownFields);
      }

      @java.lang.Override
      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.mergeUnknownFields(unknownFields);
      }


      // @@protoc_insertion_point(builder_scope:ScenePlayOwnerCheckReq)
    }

    // @@protoc_insertion_point(class_scope:ScenePlayOwnerCheckReq)
    private static final emu.grasscutter.net.proto.ScenePlayOwnerCheckReqOuterClass.ScenePlayOwnerCheckReq DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new emu.grasscutter.net.proto.ScenePlayOwnerCheckReqOuterClass.ScenePlayOwnerCheckReq();
    }

    public static emu.grasscutter.net.proto.ScenePlayOwnerCheckReqOuterClass.ScenePlayOwnerCheckReq getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<ScenePlayOwnerCheckReq>
        PARSER = new com.google.protobuf.AbstractParser<ScenePlayOwnerCheckReq>() {
      @java.lang.Override
      public ScenePlayOwnerCheckReq parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new ScenePlayOwnerCheckReq(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<ScenePlayOwnerCheckReq> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<ScenePlayOwnerCheckReq> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public emu.grasscutter.net.proto.ScenePlayOwnerCheckReqOuterClass.ScenePlayOwnerCheckReq getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ScenePlayOwnerCheckReq_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ScenePlayOwnerCheckReq_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\034ScenePlayOwnerCheckReq.proto\"@\n\026SceneP" +
      "layOwnerCheckReq\022\017\n\007play_id\030\n \001(\r\022\025\n\ris_" +
      "skip_match\030\010 \001(\010B\033\n\031emu.grasscutter.net." +
      "protob\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_ScenePlayOwnerCheckReq_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_ScenePlayOwnerCheckReq_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ScenePlayOwnerCheckReq_descriptor,
        new java.lang.String[] { "PlayId", "IsSkipMatch", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
