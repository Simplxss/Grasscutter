// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: IrodoriChessPlayerInfoNotify.proto

package emu.grasscutter.net.proto;

public final class IrodoriChessPlayerInfoNotifyOuterClass {
  private IrodoriChessPlayerInfoNotifyOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface IrodoriChessPlayerInfoNotifyOrBuilder extends
      // @@protoc_insertion_point(interface_extends:IrodoriChessPlayerInfoNotify)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>.IrodoriChessPlayerInfo player_info = 10;</code>
     * @return Whether the playerInfo field is set.
     */
    boolean hasPlayerInfo();
    /**
     * <code>.IrodoriChessPlayerInfo player_info = 10;</code>
     * @return The playerInfo.
     */
    emu.grasscutter.net.proto.IrodoriChessPlayerInfoOuterClass.IrodoriChessPlayerInfo getPlayerInfo();
    /**
     * <code>.IrodoriChessPlayerInfo player_info = 10;</code>
     */
    emu.grasscutter.net.proto.IrodoriChessPlayerInfoOuterClass.IrodoriChessPlayerInfoOrBuilder getPlayerInfoOrBuilder();
  }
  /**
   * <pre>
   * enum CmdId {
   *   option allow_alias = true;
   *   NONE = 0;
   *   CMD_ID = 5312;
   *   ENET_CHANNEL_ID = 0;
   *   ENET_IS_RELIABLE = 1;
   * }
   * </pre>
   *
   * Protobuf type {@code IrodoriChessPlayerInfoNotify}
   */
  public static final class IrodoriChessPlayerInfoNotify extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:IrodoriChessPlayerInfoNotify)
      IrodoriChessPlayerInfoNotifyOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use IrodoriChessPlayerInfoNotify.newBuilder() to construct.
    private IrodoriChessPlayerInfoNotify(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private IrodoriChessPlayerInfoNotify() {
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(
        UnusedPrivateParameter unused) {
      return new IrodoriChessPlayerInfoNotify();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private IrodoriChessPlayerInfoNotify(
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
            case 82: {
              emu.grasscutter.net.proto.IrodoriChessPlayerInfoOuterClass.IrodoriChessPlayerInfo.Builder subBuilder = null;
              if (playerInfo_ != null) {
                subBuilder = playerInfo_.toBuilder();
              }
              playerInfo_ = input.readMessage(emu.grasscutter.net.proto.IrodoriChessPlayerInfoOuterClass.IrodoriChessPlayerInfo.parser(), extensionRegistry);
              if (subBuilder != null) {
                subBuilder.mergeFrom(playerInfo_);
                playerInfo_ = subBuilder.buildPartial();
              }

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
      return emu.grasscutter.net.proto.IrodoriChessPlayerInfoNotifyOuterClass.internal_static_IrodoriChessPlayerInfoNotify_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return emu.grasscutter.net.proto.IrodoriChessPlayerInfoNotifyOuterClass.internal_static_IrodoriChessPlayerInfoNotify_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              emu.grasscutter.net.proto.IrodoriChessPlayerInfoNotifyOuterClass.IrodoriChessPlayerInfoNotify.class, emu.grasscutter.net.proto.IrodoriChessPlayerInfoNotifyOuterClass.IrodoriChessPlayerInfoNotify.Builder.class);
    }

    public static final int PLAYER_INFO_FIELD_NUMBER = 10;
    private emu.grasscutter.net.proto.IrodoriChessPlayerInfoOuterClass.IrodoriChessPlayerInfo playerInfo_;
    /**
     * <code>.IrodoriChessPlayerInfo player_info = 10;</code>
     * @return Whether the playerInfo field is set.
     */
    @java.lang.Override
    public boolean hasPlayerInfo() {
      return playerInfo_ != null;
    }
    /**
     * <code>.IrodoriChessPlayerInfo player_info = 10;</code>
     * @return The playerInfo.
     */
    @java.lang.Override
    public emu.grasscutter.net.proto.IrodoriChessPlayerInfoOuterClass.IrodoriChessPlayerInfo getPlayerInfo() {
      return playerInfo_ == null ? emu.grasscutter.net.proto.IrodoriChessPlayerInfoOuterClass.IrodoriChessPlayerInfo.getDefaultInstance() : playerInfo_;
    }
    /**
     * <code>.IrodoriChessPlayerInfo player_info = 10;</code>
     */
    @java.lang.Override
    public emu.grasscutter.net.proto.IrodoriChessPlayerInfoOuterClass.IrodoriChessPlayerInfoOrBuilder getPlayerInfoOrBuilder() {
      return getPlayerInfo();
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
      if (playerInfo_ != null) {
        output.writeMessage(10, getPlayerInfo());
      }
      unknownFields.writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (playerInfo_ != null) {
        size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(10, getPlayerInfo());
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
      if (!(obj instanceof emu.grasscutter.net.proto.IrodoriChessPlayerInfoNotifyOuterClass.IrodoriChessPlayerInfoNotify)) {
        return super.equals(obj);
      }
      emu.grasscutter.net.proto.IrodoriChessPlayerInfoNotifyOuterClass.IrodoriChessPlayerInfoNotify other = (emu.grasscutter.net.proto.IrodoriChessPlayerInfoNotifyOuterClass.IrodoriChessPlayerInfoNotify) obj;

      if (hasPlayerInfo() != other.hasPlayerInfo()) return false;
      if (hasPlayerInfo()) {
        if (!getPlayerInfo()
            .equals(other.getPlayerInfo())) return false;
      }
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
      if (hasPlayerInfo()) {
        hash = (37 * hash) + PLAYER_INFO_FIELD_NUMBER;
        hash = (53 * hash) + getPlayerInfo().hashCode();
      }
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static emu.grasscutter.net.proto.IrodoriChessPlayerInfoNotifyOuterClass.IrodoriChessPlayerInfoNotify parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static emu.grasscutter.net.proto.IrodoriChessPlayerInfoNotifyOuterClass.IrodoriChessPlayerInfoNotify parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static emu.grasscutter.net.proto.IrodoriChessPlayerInfoNotifyOuterClass.IrodoriChessPlayerInfoNotify parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static emu.grasscutter.net.proto.IrodoriChessPlayerInfoNotifyOuterClass.IrodoriChessPlayerInfoNotify parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static emu.grasscutter.net.proto.IrodoriChessPlayerInfoNotifyOuterClass.IrodoriChessPlayerInfoNotify parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static emu.grasscutter.net.proto.IrodoriChessPlayerInfoNotifyOuterClass.IrodoriChessPlayerInfoNotify parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static emu.grasscutter.net.proto.IrodoriChessPlayerInfoNotifyOuterClass.IrodoriChessPlayerInfoNotify parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static emu.grasscutter.net.proto.IrodoriChessPlayerInfoNotifyOuterClass.IrodoriChessPlayerInfoNotify parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static emu.grasscutter.net.proto.IrodoriChessPlayerInfoNotifyOuterClass.IrodoriChessPlayerInfoNotify parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static emu.grasscutter.net.proto.IrodoriChessPlayerInfoNotifyOuterClass.IrodoriChessPlayerInfoNotify parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static emu.grasscutter.net.proto.IrodoriChessPlayerInfoNotifyOuterClass.IrodoriChessPlayerInfoNotify parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static emu.grasscutter.net.proto.IrodoriChessPlayerInfoNotifyOuterClass.IrodoriChessPlayerInfoNotify parseFrom(
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
    public static Builder newBuilder(emu.grasscutter.net.proto.IrodoriChessPlayerInfoNotifyOuterClass.IrodoriChessPlayerInfoNotify prototype) {
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
     *   CMD_ID = 5312;
     *   ENET_CHANNEL_ID = 0;
     *   ENET_IS_RELIABLE = 1;
     * }
     * </pre>
     *
     * Protobuf type {@code IrodoriChessPlayerInfoNotify}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:IrodoriChessPlayerInfoNotify)
        emu.grasscutter.net.proto.IrodoriChessPlayerInfoNotifyOuterClass.IrodoriChessPlayerInfoNotifyOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return emu.grasscutter.net.proto.IrodoriChessPlayerInfoNotifyOuterClass.internal_static_IrodoriChessPlayerInfoNotify_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return emu.grasscutter.net.proto.IrodoriChessPlayerInfoNotifyOuterClass.internal_static_IrodoriChessPlayerInfoNotify_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                emu.grasscutter.net.proto.IrodoriChessPlayerInfoNotifyOuterClass.IrodoriChessPlayerInfoNotify.class, emu.grasscutter.net.proto.IrodoriChessPlayerInfoNotifyOuterClass.IrodoriChessPlayerInfoNotify.Builder.class);
      }

      // Construct using emu.grasscutter.net.proto.IrodoriChessPlayerInfoNotifyOuterClass.IrodoriChessPlayerInfoNotify.newBuilder()
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
        if (playerInfoBuilder_ == null) {
          playerInfo_ = null;
        } else {
          playerInfo_ = null;
          playerInfoBuilder_ = null;
        }
        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return emu.grasscutter.net.proto.IrodoriChessPlayerInfoNotifyOuterClass.internal_static_IrodoriChessPlayerInfoNotify_descriptor;
      }

      @java.lang.Override
      public emu.grasscutter.net.proto.IrodoriChessPlayerInfoNotifyOuterClass.IrodoriChessPlayerInfoNotify getDefaultInstanceForType() {
        return emu.grasscutter.net.proto.IrodoriChessPlayerInfoNotifyOuterClass.IrodoriChessPlayerInfoNotify.getDefaultInstance();
      }

      @java.lang.Override
      public emu.grasscutter.net.proto.IrodoriChessPlayerInfoNotifyOuterClass.IrodoriChessPlayerInfoNotify build() {
        emu.grasscutter.net.proto.IrodoriChessPlayerInfoNotifyOuterClass.IrodoriChessPlayerInfoNotify result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public emu.grasscutter.net.proto.IrodoriChessPlayerInfoNotifyOuterClass.IrodoriChessPlayerInfoNotify buildPartial() {
        emu.grasscutter.net.proto.IrodoriChessPlayerInfoNotifyOuterClass.IrodoriChessPlayerInfoNotify result = new emu.grasscutter.net.proto.IrodoriChessPlayerInfoNotifyOuterClass.IrodoriChessPlayerInfoNotify(this);
        if (playerInfoBuilder_ == null) {
          result.playerInfo_ = playerInfo_;
        } else {
          result.playerInfo_ = playerInfoBuilder_.build();
        }
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
        if (other instanceof emu.grasscutter.net.proto.IrodoriChessPlayerInfoNotifyOuterClass.IrodoriChessPlayerInfoNotify) {
          return mergeFrom((emu.grasscutter.net.proto.IrodoriChessPlayerInfoNotifyOuterClass.IrodoriChessPlayerInfoNotify)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(emu.grasscutter.net.proto.IrodoriChessPlayerInfoNotifyOuterClass.IrodoriChessPlayerInfoNotify other) {
        if (other == emu.grasscutter.net.proto.IrodoriChessPlayerInfoNotifyOuterClass.IrodoriChessPlayerInfoNotify.getDefaultInstance()) return this;
        if (other.hasPlayerInfo()) {
          mergePlayerInfo(other.getPlayerInfo());
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
        emu.grasscutter.net.proto.IrodoriChessPlayerInfoNotifyOuterClass.IrodoriChessPlayerInfoNotify parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (emu.grasscutter.net.proto.IrodoriChessPlayerInfoNotifyOuterClass.IrodoriChessPlayerInfoNotify) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private emu.grasscutter.net.proto.IrodoriChessPlayerInfoOuterClass.IrodoriChessPlayerInfo playerInfo_;
      private com.google.protobuf.SingleFieldBuilderV3<
          emu.grasscutter.net.proto.IrodoriChessPlayerInfoOuterClass.IrodoriChessPlayerInfo, emu.grasscutter.net.proto.IrodoriChessPlayerInfoOuterClass.IrodoriChessPlayerInfo.Builder, emu.grasscutter.net.proto.IrodoriChessPlayerInfoOuterClass.IrodoriChessPlayerInfoOrBuilder> playerInfoBuilder_;
      /**
       * <code>.IrodoriChessPlayerInfo player_info = 10;</code>
       * @return Whether the playerInfo field is set.
       */
      public boolean hasPlayerInfo() {
        return playerInfoBuilder_ != null || playerInfo_ != null;
      }
      /**
       * <code>.IrodoriChessPlayerInfo player_info = 10;</code>
       * @return The playerInfo.
       */
      public emu.grasscutter.net.proto.IrodoriChessPlayerInfoOuterClass.IrodoriChessPlayerInfo getPlayerInfo() {
        if (playerInfoBuilder_ == null) {
          return playerInfo_ == null ? emu.grasscutter.net.proto.IrodoriChessPlayerInfoOuterClass.IrodoriChessPlayerInfo.getDefaultInstance() : playerInfo_;
        } else {
          return playerInfoBuilder_.getMessage();
        }
      }
      /**
       * <code>.IrodoriChessPlayerInfo player_info = 10;</code>
       */
      public Builder setPlayerInfo(emu.grasscutter.net.proto.IrodoriChessPlayerInfoOuterClass.IrodoriChessPlayerInfo value) {
        if (playerInfoBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          playerInfo_ = value;
          onChanged();
        } else {
          playerInfoBuilder_.setMessage(value);
        }

        return this;
      }
      /**
       * <code>.IrodoriChessPlayerInfo player_info = 10;</code>
       */
      public Builder setPlayerInfo(
          emu.grasscutter.net.proto.IrodoriChessPlayerInfoOuterClass.IrodoriChessPlayerInfo.Builder builderForValue) {
        if (playerInfoBuilder_ == null) {
          playerInfo_ = builderForValue.build();
          onChanged();
        } else {
          playerInfoBuilder_.setMessage(builderForValue.build());
        }

        return this;
      }
      /**
       * <code>.IrodoriChessPlayerInfo player_info = 10;</code>
       */
      public Builder mergePlayerInfo(emu.grasscutter.net.proto.IrodoriChessPlayerInfoOuterClass.IrodoriChessPlayerInfo value) {
        if (playerInfoBuilder_ == null) {
          if (playerInfo_ != null) {
            playerInfo_ =
              emu.grasscutter.net.proto.IrodoriChessPlayerInfoOuterClass.IrodoriChessPlayerInfo.newBuilder(playerInfo_).mergeFrom(value).buildPartial();
          } else {
            playerInfo_ = value;
          }
          onChanged();
        } else {
          playerInfoBuilder_.mergeFrom(value);
        }

        return this;
      }
      /**
       * <code>.IrodoriChessPlayerInfo player_info = 10;</code>
       */
      public Builder clearPlayerInfo() {
        if (playerInfoBuilder_ == null) {
          playerInfo_ = null;
          onChanged();
        } else {
          playerInfo_ = null;
          playerInfoBuilder_ = null;
        }

        return this;
      }
      /**
       * <code>.IrodoriChessPlayerInfo player_info = 10;</code>
       */
      public emu.grasscutter.net.proto.IrodoriChessPlayerInfoOuterClass.IrodoriChessPlayerInfo.Builder getPlayerInfoBuilder() {
        
        onChanged();
        return getPlayerInfoFieldBuilder().getBuilder();
      }
      /**
       * <code>.IrodoriChessPlayerInfo player_info = 10;</code>
       */
      public emu.grasscutter.net.proto.IrodoriChessPlayerInfoOuterClass.IrodoriChessPlayerInfoOrBuilder getPlayerInfoOrBuilder() {
        if (playerInfoBuilder_ != null) {
          return playerInfoBuilder_.getMessageOrBuilder();
        } else {
          return playerInfo_ == null ?
              emu.grasscutter.net.proto.IrodoriChessPlayerInfoOuterClass.IrodoriChessPlayerInfo.getDefaultInstance() : playerInfo_;
        }
      }
      /**
       * <code>.IrodoriChessPlayerInfo player_info = 10;</code>
       */
      private com.google.protobuf.SingleFieldBuilderV3<
          emu.grasscutter.net.proto.IrodoriChessPlayerInfoOuterClass.IrodoriChessPlayerInfo, emu.grasscutter.net.proto.IrodoriChessPlayerInfoOuterClass.IrodoriChessPlayerInfo.Builder, emu.grasscutter.net.proto.IrodoriChessPlayerInfoOuterClass.IrodoriChessPlayerInfoOrBuilder> 
          getPlayerInfoFieldBuilder() {
        if (playerInfoBuilder_ == null) {
          playerInfoBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
              emu.grasscutter.net.proto.IrodoriChessPlayerInfoOuterClass.IrodoriChessPlayerInfo, emu.grasscutter.net.proto.IrodoriChessPlayerInfoOuterClass.IrodoriChessPlayerInfo.Builder, emu.grasscutter.net.proto.IrodoriChessPlayerInfoOuterClass.IrodoriChessPlayerInfoOrBuilder>(
                  getPlayerInfo(),
                  getParentForChildren(),
                  isClean());
          playerInfo_ = null;
        }
        return playerInfoBuilder_;
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


      // @@protoc_insertion_point(builder_scope:IrodoriChessPlayerInfoNotify)
    }

    // @@protoc_insertion_point(class_scope:IrodoriChessPlayerInfoNotify)
    private static final emu.grasscutter.net.proto.IrodoriChessPlayerInfoNotifyOuterClass.IrodoriChessPlayerInfoNotify DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new emu.grasscutter.net.proto.IrodoriChessPlayerInfoNotifyOuterClass.IrodoriChessPlayerInfoNotify();
    }

    public static emu.grasscutter.net.proto.IrodoriChessPlayerInfoNotifyOuterClass.IrodoriChessPlayerInfoNotify getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<IrodoriChessPlayerInfoNotify>
        PARSER = new com.google.protobuf.AbstractParser<IrodoriChessPlayerInfoNotify>() {
      @java.lang.Override
      public IrodoriChessPlayerInfoNotify parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new IrodoriChessPlayerInfoNotify(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<IrodoriChessPlayerInfoNotify> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<IrodoriChessPlayerInfoNotify> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public emu.grasscutter.net.proto.IrodoriChessPlayerInfoNotifyOuterClass.IrodoriChessPlayerInfoNotify getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_IrodoriChessPlayerInfoNotify_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_IrodoriChessPlayerInfoNotify_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\"IrodoriChessPlayerInfoNotify.proto\032\034Ir" +
      "odoriChessPlayerInfo.proto\"L\n\034IrodoriChe" +
      "ssPlayerInfoNotify\022,\n\013player_info\030\n \001(\0132" +
      "\027.IrodoriChessPlayerInfoB\033\n\031emu.grasscut" +
      "ter.net.protob\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          emu.grasscutter.net.proto.IrodoriChessPlayerInfoOuterClass.getDescriptor(),
        });
    internal_static_IrodoriChessPlayerInfoNotify_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_IrodoriChessPlayerInfoNotify_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_IrodoriChessPlayerInfoNotify_descriptor,
        new java.lang.String[] { "PlayerInfo", });
    emu.grasscutter.net.proto.IrodoriChessPlayerInfoOuterClass.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
