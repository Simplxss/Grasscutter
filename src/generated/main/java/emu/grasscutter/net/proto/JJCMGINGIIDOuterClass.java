// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: JJCMGINGIID.proto

package emu.grasscutter.net.proto;

public final class JJCMGINGIIDOuterClass {
  private JJCMGINGIIDOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface JJCMGINGIIDOrBuilder extends
      // @@protoc_insertion_point(interface_extends:JJCMGINGIID)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>bool LHMLLKALIKN = 15;</code>
     * @return The lHMLLKALIKN.
     */
    boolean getLHMLLKALIKN();

    /**
     * <code>int32 retcode = 14;</code>
     * @return The retcode.
     */
    int getRetcode();

    /**
     * <code>bool CIBAGAJCPEN = 5;</code>
     * @return The cIBAGAJCPEN.
     */
    boolean getCIBAGAJCPEN();
  }
  /**
   * <pre>
   * CmdId: 3964
   * </pre>
   *
   * Protobuf type {@code JJCMGINGIID}
   */
  public static final class JJCMGINGIID extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:JJCMGINGIID)
      JJCMGINGIIDOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use JJCMGINGIID.newBuilder() to construct.
    private JJCMGINGIID(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private JJCMGINGIID() {
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(
        UnusedPrivateParameter unused) {
      return new JJCMGINGIID();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private JJCMGINGIID(
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
            case 40: {

              cIBAGAJCPEN_ = input.readBool();
              break;
            }
            case 112: {

              retcode_ = input.readInt32();
              break;
            }
            case 120: {

              lHMLLKALIKN_ = input.readBool();
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
      return emu.grasscutter.net.proto.JJCMGINGIIDOuterClass.internal_static_JJCMGINGIID_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return emu.grasscutter.net.proto.JJCMGINGIIDOuterClass.internal_static_JJCMGINGIID_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              emu.grasscutter.net.proto.JJCMGINGIIDOuterClass.JJCMGINGIID.class, emu.grasscutter.net.proto.JJCMGINGIIDOuterClass.JJCMGINGIID.Builder.class);
    }

    public static final int LHMLLKALIKN_FIELD_NUMBER = 15;
    private boolean lHMLLKALIKN_;
    /**
     * <code>bool LHMLLKALIKN = 15;</code>
     * @return The lHMLLKALIKN.
     */
    @java.lang.Override
    public boolean getLHMLLKALIKN() {
      return lHMLLKALIKN_;
    }

    public static final int RETCODE_FIELD_NUMBER = 14;
    private int retcode_;
    /**
     * <code>int32 retcode = 14;</code>
     * @return The retcode.
     */
    @java.lang.Override
    public int getRetcode() {
      return retcode_;
    }

    public static final int CIBAGAJCPEN_FIELD_NUMBER = 5;
    private boolean cIBAGAJCPEN_;
    /**
     * <code>bool CIBAGAJCPEN = 5;</code>
     * @return The cIBAGAJCPEN.
     */
    @java.lang.Override
    public boolean getCIBAGAJCPEN() {
      return cIBAGAJCPEN_;
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
      if (cIBAGAJCPEN_ != false) {
        output.writeBool(5, cIBAGAJCPEN_);
      }
      if (retcode_ != 0) {
        output.writeInt32(14, retcode_);
      }
      if (lHMLLKALIKN_ != false) {
        output.writeBool(15, lHMLLKALIKN_);
      }
      unknownFields.writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (cIBAGAJCPEN_ != false) {
        size += com.google.protobuf.CodedOutputStream
          .computeBoolSize(5, cIBAGAJCPEN_);
      }
      if (retcode_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(14, retcode_);
      }
      if (lHMLLKALIKN_ != false) {
        size += com.google.protobuf.CodedOutputStream
          .computeBoolSize(15, lHMLLKALIKN_);
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
      if (!(obj instanceof emu.grasscutter.net.proto.JJCMGINGIIDOuterClass.JJCMGINGIID)) {
        return super.equals(obj);
      }
      emu.grasscutter.net.proto.JJCMGINGIIDOuterClass.JJCMGINGIID other = (emu.grasscutter.net.proto.JJCMGINGIIDOuterClass.JJCMGINGIID) obj;

      if (getLHMLLKALIKN()
          != other.getLHMLLKALIKN()) return false;
      if (getRetcode()
          != other.getRetcode()) return false;
      if (getCIBAGAJCPEN()
          != other.getCIBAGAJCPEN()) return false;
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
      hash = (37 * hash) + LHMLLKALIKN_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
          getLHMLLKALIKN());
      hash = (37 * hash) + RETCODE_FIELD_NUMBER;
      hash = (53 * hash) + getRetcode();
      hash = (37 * hash) + CIBAGAJCPEN_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
          getCIBAGAJCPEN());
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static emu.grasscutter.net.proto.JJCMGINGIIDOuterClass.JJCMGINGIID parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static emu.grasscutter.net.proto.JJCMGINGIIDOuterClass.JJCMGINGIID parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static emu.grasscutter.net.proto.JJCMGINGIIDOuterClass.JJCMGINGIID parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static emu.grasscutter.net.proto.JJCMGINGIIDOuterClass.JJCMGINGIID parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static emu.grasscutter.net.proto.JJCMGINGIIDOuterClass.JJCMGINGIID parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static emu.grasscutter.net.proto.JJCMGINGIIDOuterClass.JJCMGINGIID parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static emu.grasscutter.net.proto.JJCMGINGIIDOuterClass.JJCMGINGIID parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static emu.grasscutter.net.proto.JJCMGINGIIDOuterClass.JJCMGINGIID parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static emu.grasscutter.net.proto.JJCMGINGIIDOuterClass.JJCMGINGIID parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static emu.grasscutter.net.proto.JJCMGINGIIDOuterClass.JJCMGINGIID parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static emu.grasscutter.net.proto.JJCMGINGIIDOuterClass.JJCMGINGIID parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static emu.grasscutter.net.proto.JJCMGINGIIDOuterClass.JJCMGINGIID parseFrom(
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
    public static Builder newBuilder(emu.grasscutter.net.proto.JJCMGINGIIDOuterClass.JJCMGINGIID prototype) {
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
     * CmdId: 3964
     * </pre>
     *
     * Protobuf type {@code JJCMGINGIID}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:JJCMGINGIID)
        emu.grasscutter.net.proto.JJCMGINGIIDOuterClass.JJCMGINGIIDOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return emu.grasscutter.net.proto.JJCMGINGIIDOuterClass.internal_static_JJCMGINGIID_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return emu.grasscutter.net.proto.JJCMGINGIIDOuterClass.internal_static_JJCMGINGIID_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                emu.grasscutter.net.proto.JJCMGINGIIDOuterClass.JJCMGINGIID.class, emu.grasscutter.net.proto.JJCMGINGIIDOuterClass.JJCMGINGIID.Builder.class);
      }

      // Construct using emu.grasscutter.net.proto.JJCMGINGIIDOuterClass.JJCMGINGIID.newBuilder()
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
        lHMLLKALIKN_ = false;

        retcode_ = 0;

        cIBAGAJCPEN_ = false;

        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return emu.grasscutter.net.proto.JJCMGINGIIDOuterClass.internal_static_JJCMGINGIID_descriptor;
      }

      @java.lang.Override
      public emu.grasscutter.net.proto.JJCMGINGIIDOuterClass.JJCMGINGIID getDefaultInstanceForType() {
        return emu.grasscutter.net.proto.JJCMGINGIIDOuterClass.JJCMGINGIID.getDefaultInstance();
      }

      @java.lang.Override
      public emu.grasscutter.net.proto.JJCMGINGIIDOuterClass.JJCMGINGIID build() {
        emu.grasscutter.net.proto.JJCMGINGIIDOuterClass.JJCMGINGIID result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public emu.grasscutter.net.proto.JJCMGINGIIDOuterClass.JJCMGINGIID buildPartial() {
        emu.grasscutter.net.proto.JJCMGINGIIDOuterClass.JJCMGINGIID result = new emu.grasscutter.net.proto.JJCMGINGIIDOuterClass.JJCMGINGIID(this);
        result.lHMLLKALIKN_ = lHMLLKALIKN_;
        result.retcode_ = retcode_;
        result.cIBAGAJCPEN_ = cIBAGAJCPEN_;
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
        if (other instanceof emu.grasscutter.net.proto.JJCMGINGIIDOuterClass.JJCMGINGIID) {
          return mergeFrom((emu.grasscutter.net.proto.JJCMGINGIIDOuterClass.JJCMGINGIID)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(emu.grasscutter.net.proto.JJCMGINGIIDOuterClass.JJCMGINGIID other) {
        if (other == emu.grasscutter.net.proto.JJCMGINGIIDOuterClass.JJCMGINGIID.getDefaultInstance()) return this;
        if (other.getLHMLLKALIKN() != false) {
          setLHMLLKALIKN(other.getLHMLLKALIKN());
        }
        if (other.getRetcode() != 0) {
          setRetcode(other.getRetcode());
        }
        if (other.getCIBAGAJCPEN() != false) {
          setCIBAGAJCPEN(other.getCIBAGAJCPEN());
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
        emu.grasscutter.net.proto.JJCMGINGIIDOuterClass.JJCMGINGIID parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (emu.grasscutter.net.proto.JJCMGINGIIDOuterClass.JJCMGINGIID) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private boolean lHMLLKALIKN_ ;
      /**
       * <code>bool LHMLLKALIKN = 15;</code>
       * @return The lHMLLKALIKN.
       */
      @java.lang.Override
      public boolean getLHMLLKALIKN() {
        return lHMLLKALIKN_;
      }
      /**
       * <code>bool LHMLLKALIKN = 15;</code>
       * @param value The lHMLLKALIKN to set.
       * @return This builder for chaining.
       */
      public Builder setLHMLLKALIKN(boolean value) {
        
        lHMLLKALIKN_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>bool LHMLLKALIKN = 15;</code>
       * @return This builder for chaining.
       */
      public Builder clearLHMLLKALIKN() {
        
        lHMLLKALIKN_ = false;
        onChanged();
        return this;
      }

      private int retcode_ ;
      /**
       * <code>int32 retcode = 14;</code>
       * @return The retcode.
       */
      @java.lang.Override
      public int getRetcode() {
        return retcode_;
      }
      /**
       * <code>int32 retcode = 14;</code>
       * @param value The retcode to set.
       * @return This builder for chaining.
       */
      public Builder setRetcode(int value) {
        
        retcode_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int32 retcode = 14;</code>
       * @return This builder for chaining.
       */
      public Builder clearRetcode() {
        
        retcode_ = 0;
        onChanged();
        return this;
      }

      private boolean cIBAGAJCPEN_ ;
      /**
       * <code>bool CIBAGAJCPEN = 5;</code>
       * @return The cIBAGAJCPEN.
       */
      @java.lang.Override
      public boolean getCIBAGAJCPEN() {
        return cIBAGAJCPEN_;
      }
      /**
       * <code>bool CIBAGAJCPEN = 5;</code>
       * @param value The cIBAGAJCPEN to set.
       * @return This builder for chaining.
       */
      public Builder setCIBAGAJCPEN(boolean value) {
        
        cIBAGAJCPEN_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>bool CIBAGAJCPEN = 5;</code>
       * @return This builder for chaining.
       */
      public Builder clearCIBAGAJCPEN() {
        
        cIBAGAJCPEN_ = false;
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


      // @@protoc_insertion_point(builder_scope:JJCMGINGIID)
    }

    // @@protoc_insertion_point(class_scope:JJCMGINGIID)
    private static final emu.grasscutter.net.proto.JJCMGINGIIDOuterClass.JJCMGINGIID DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new emu.grasscutter.net.proto.JJCMGINGIIDOuterClass.JJCMGINGIID();
    }

    public static emu.grasscutter.net.proto.JJCMGINGIIDOuterClass.JJCMGINGIID getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<JJCMGINGIID>
        PARSER = new com.google.protobuf.AbstractParser<JJCMGINGIID>() {
      @java.lang.Override
      public JJCMGINGIID parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new JJCMGINGIID(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<JJCMGINGIID> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<JJCMGINGIID> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public emu.grasscutter.net.proto.JJCMGINGIIDOuterClass.JJCMGINGIID getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_JJCMGINGIID_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_JJCMGINGIID_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\021JJCMGINGIID.proto\"H\n\013JJCMGINGIID\022\023\n\013LH" +
      "MLLKALIKN\030\017 \001(\010\022\017\n\007retcode\030\016 \001(\005\022\023\n\013CIBA" +
      "GAJCPEN\030\005 \001(\010B\033\n\031emu.grasscutter.net.pro" +
      "tob\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_JJCMGINGIID_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_JJCMGINGIID_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_JJCMGINGIID_descriptor,
        new java.lang.String[] { "LHMLLKALIKN", "Retcode", "CIBAGAJCPEN", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}