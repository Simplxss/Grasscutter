// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: EffigyChallengeV2SettleInfo.proto

package emu.grasscutter.net.proto;

public final class EffigyChallengeV2SettleInfoOuterClass {
  private EffigyChallengeV2SettleInfoOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface EffigyChallengeV2SettleInfoOrBuilder extends
      // @@protoc_insertion_point(interface_extends:EffigyChallengeV2SettleInfo)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>uint32 challenge_mode_difficulty = 13;</code>
     * @return The challengeModeDifficulty.
     */
    int getChallengeModeDifficulty();

    /**
     * <code>uint32 Unk3300_MHOIIPJKAMN = 14;</code>
     * @return The unk3300MHOIIPJKAMN.
     */
    int getUnk3300MHOIIPJKAMN();

    /**
     * <code>uint32 Unk3300_PHEIMLOKIJG = 11;</code>
     * @return The unk3300PHEIMLOKIJG.
     */
    int getUnk3300PHEIMLOKIJG();

    /**
     * <code>uint32 Unk3300_ONKPGFOLDFL = 12;</code>
     * @return The unk3300ONKPGFOLDFL.
     */
    int getUnk3300ONKPGFOLDFL();

    /**
     * <code>bool Unk3300_NGBKNDHJPCP = 5;</code>
     * @return The unk3300NGBKNDHJPCP.
     */
    boolean getUnk3300NGBKNDHJPCP();

    /**
     * <code>bool Unk3300_AKMPCDIKBJD = 9;</code>
     * @return The unk3300AKMPCDIKBJD.
     */
    boolean getUnk3300AKMPCDIKBJD();
  }
  /**
   * Protobuf type {@code EffigyChallengeV2SettleInfo}
   */
  public static final class EffigyChallengeV2SettleInfo extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:EffigyChallengeV2SettleInfo)
      EffigyChallengeV2SettleInfoOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use EffigyChallengeV2SettleInfo.newBuilder() to construct.
    private EffigyChallengeV2SettleInfo(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private EffigyChallengeV2SettleInfo() {
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(
        UnusedPrivateParameter unused) {
      return new EffigyChallengeV2SettleInfo();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private EffigyChallengeV2SettleInfo(
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

              unk3300NGBKNDHJPCP_ = input.readBool();
              break;
            }
            case 72: {

              unk3300AKMPCDIKBJD_ = input.readBool();
              break;
            }
            case 88: {

              unk3300PHEIMLOKIJG_ = input.readUInt32();
              break;
            }
            case 96: {

              unk3300ONKPGFOLDFL_ = input.readUInt32();
              break;
            }
            case 104: {

              challengeModeDifficulty_ = input.readUInt32();
              break;
            }
            case 112: {

              unk3300MHOIIPJKAMN_ = input.readUInt32();
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
      return emu.grasscutter.net.proto.EffigyChallengeV2SettleInfoOuterClass.internal_static_EffigyChallengeV2SettleInfo_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return emu.grasscutter.net.proto.EffigyChallengeV2SettleInfoOuterClass.internal_static_EffigyChallengeV2SettleInfo_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              emu.grasscutter.net.proto.EffigyChallengeV2SettleInfoOuterClass.EffigyChallengeV2SettleInfo.class, emu.grasscutter.net.proto.EffigyChallengeV2SettleInfoOuterClass.EffigyChallengeV2SettleInfo.Builder.class);
    }

    public static final int CHALLENGE_MODE_DIFFICULTY_FIELD_NUMBER = 13;
    private int challengeModeDifficulty_;
    /**
     * <code>uint32 challenge_mode_difficulty = 13;</code>
     * @return The challengeModeDifficulty.
     */
    @java.lang.Override
    public int getChallengeModeDifficulty() {
      return challengeModeDifficulty_;
    }

    public static final int UNK3300_MHOIIPJKAMN_FIELD_NUMBER = 14;
    private int unk3300MHOIIPJKAMN_;
    /**
     * <code>uint32 Unk3300_MHOIIPJKAMN = 14;</code>
     * @return The unk3300MHOIIPJKAMN.
     */
    @java.lang.Override
    public int getUnk3300MHOIIPJKAMN() {
      return unk3300MHOIIPJKAMN_;
    }

    public static final int UNK3300_PHEIMLOKIJG_FIELD_NUMBER = 11;
    private int unk3300PHEIMLOKIJG_;
    /**
     * <code>uint32 Unk3300_PHEIMLOKIJG = 11;</code>
     * @return The unk3300PHEIMLOKIJG.
     */
    @java.lang.Override
    public int getUnk3300PHEIMLOKIJG() {
      return unk3300PHEIMLOKIJG_;
    }

    public static final int UNK3300_ONKPGFOLDFL_FIELD_NUMBER = 12;
    private int unk3300ONKPGFOLDFL_;
    /**
     * <code>uint32 Unk3300_ONKPGFOLDFL = 12;</code>
     * @return The unk3300ONKPGFOLDFL.
     */
    @java.lang.Override
    public int getUnk3300ONKPGFOLDFL() {
      return unk3300ONKPGFOLDFL_;
    }

    public static final int UNK3300_NGBKNDHJPCP_FIELD_NUMBER = 5;
    private boolean unk3300NGBKNDHJPCP_;
    /**
     * <code>bool Unk3300_NGBKNDHJPCP = 5;</code>
     * @return The unk3300NGBKNDHJPCP.
     */
    @java.lang.Override
    public boolean getUnk3300NGBKNDHJPCP() {
      return unk3300NGBKNDHJPCP_;
    }

    public static final int UNK3300_AKMPCDIKBJD_FIELD_NUMBER = 9;
    private boolean unk3300AKMPCDIKBJD_;
    /**
     * <code>bool Unk3300_AKMPCDIKBJD = 9;</code>
     * @return The unk3300AKMPCDIKBJD.
     */
    @java.lang.Override
    public boolean getUnk3300AKMPCDIKBJD() {
      return unk3300AKMPCDIKBJD_;
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
      if (unk3300NGBKNDHJPCP_ != false) {
        output.writeBool(5, unk3300NGBKNDHJPCP_);
      }
      if (unk3300AKMPCDIKBJD_ != false) {
        output.writeBool(9, unk3300AKMPCDIKBJD_);
      }
      if (unk3300PHEIMLOKIJG_ != 0) {
        output.writeUInt32(11, unk3300PHEIMLOKIJG_);
      }
      if (unk3300ONKPGFOLDFL_ != 0) {
        output.writeUInt32(12, unk3300ONKPGFOLDFL_);
      }
      if (challengeModeDifficulty_ != 0) {
        output.writeUInt32(13, challengeModeDifficulty_);
      }
      if (unk3300MHOIIPJKAMN_ != 0) {
        output.writeUInt32(14, unk3300MHOIIPJKAMN_);
      }
      unknownFields.writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (unk3300NGBKNDHJPCP_ != false) {
        size += com.google.protobuf.CodedOutputStream
          .computeBoolSize(5, unk3300NGBKNDHJPCP_);
      }
      if (unk3300AKMPCDIKBJD_ != false) {
        size += com.google.protobuf.CodedOutputStream
          .computeBoolSize(9, unk3300AKMPCDIKBJD_);
      }
      if (unk3300PHEIMLOKIJG_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeUInt32Size(11, unk3300PHEIMLOKIJG_);
      }
      if (unk3300ONKPGFOLDFL_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeUInt32Size(12, unk3300ONKPGFOLDFL_);
      }
      if (challengeModeDifficulty_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeUInt32Size(13, challengeModeDifficulty_);
      }
      if (unk3300MHOIIPJKAMN_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeUInt32Size(14, unk3300MHOIIPJKAMN_);
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
      if (!(obj instanceof emu.grasscutter.net.proto.EffigyChallengeV2SettleInfoOuterClass.EffigyChallengeV2SettleInfo)) {
        return super.equals(obj);
      }
      emu.grasscutter.net.proto.EffigyChallengeV2SettleInfoOuterClass.EffigyChallengeV2SettleInfo other = (emu.grasscutter.net.proto.EffigyChallengeV2SettleInfoOuterClass.EffigyChallengeV2SettleInfo) obj;

      if (getChallengeModeDifficulty()
          != other.getChallengeModeDifficulty()) return false;
      if (getUnk3300MHOIIPJKAMN()
          != other.getUnk3300MHOIIPJKAMN()) return false;
      if (getUnk3300PHEIMLOKIJG()
          != other.getUnk3300PHEIMLOKIJG()) return false;
      if (getUnk3300ONKPGFOLDFL()
          != other.getUnk3300ONKPGFOLDFL()) return false;
      if (getUnk3300NGBKNDHJPCP()
          != other.getUnk3300NGBKNDHJPCP()) return false;
      if (getUnk3300AKMPCDIKBJD()
          != other.getUnk3300AKMPCDIKBJD()) return false;
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
      hash = (37 * hash) + CHALLENGE_MODE_DIFFICULTY_FIELD_NUMBER;
      hash = (53 * hash) + getChallengeModeDifficulty();
      hash = (37 * hash) + UNK3300_MHOIIPJKAMN_FIELD_NUMBER;
      hash = (53 * hash) + getUnk3300MHOIIPJKAMN();
      hash = (37 * hash) + UNK3300_PHEIMLOKIJG_FIELD_NUMBER;
      hash = (53 * hash) + getUnk3300PHEIMLOKIJG();
      hash = (37 * hash) + UNK3300_ONKPGFOLDFL_FIELD_NUMBER;
      hash = (53 * hash) + getUnk3300ONKPGFOLDFL();
      hash = (37 * hash) + UNK3300_NGBKNDHJPCP_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
          getUnk3300NGBKNDHJPCP());
      hash = (37 * hash) + UNK3300_AKMPCDIKBJD_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
          getUnk3300AKMPCDIKBJD());
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static emu.grasscutter.net.proto.EffigyChallengeV2SettleInfoOuterClass.EffigyChallengeV2SettleInfo parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static emu.grasscutter.net.proto.EffigyChallengeV2SettleInfoOuterClass.EffigyChallengeV2SettleInfo parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static emu.grasscutter.net.proto.EffigyChallengeV2SettleInfoOuterClass.EffigyChallengeV2SettleInfo parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static emu.grasscutter.net.proto.EffigyChallengeV2SettleInfoOuterClass.EffigyChallengeV2SettleInfo parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static emu.grasscutter.net.proto.EffigyChallengeV2SettleInfoOuterClass.EffigyChallengeV2SettleInfo parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static emu.grasscutter.net.proto.EffigyChallengeV2SettleInfoOuterClass.EffigyChallengeV2SettleInfo parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static emu.grasscutter.net.proto.EffigyChallengeV2SettleInfoOuterClass.EffigyChallengeV2SettleInfo parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static emu.grasscutter.net.proto.EffigyChallengeV2SettleInfoOuterClass.EffigyChallengeV2SettleInfo parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static emu.grasscutter.net.proto.EffigyChallengeV2SettleInfoOuterClass.EffigyChallengeV2SettleInfo parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static emu.grasscutter.net.proto.EffigyChallengeV2SettleInfoOuterClass.EffigyChallengeV2SettleInfo parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static emu.grasscutter.net.proto.EffigyChallengeV2SettleInfoOuterClass.EffigyChallengeV2SettleInfo parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static emu.grasscutter.net.proto.EffigyChallengeV2SettleInfoOuterClass.EffigyChallengeV2SettleInfo parseFrom(
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
    public static Builder newBuilder(emu.grasscutter.net.proto.EffigyChallengeV2SettleInfoOuterClass.EffigyChallengeV2SettleInfo prototype) {
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
     * Protobuf type {@code EffigyChallengeV2SettleInfo}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:EffigyChallengeV2SettleInfo)
        emu.grasscutter.net.proto.EffigyChallengeV2SettleInfoOuterClass.EffigyChallengeV2SettleInfoOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return emu.grasscutter.net.proto.EffigyChallengeV2SettleInfoOuterClass.internal_static_EffigyChallengeV2SettleInfo_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return emu.grasscutter.net.proto.EffigyChallengeV2SettleInfoOuterClass.internal_static_EffigyChallengeV2SettleInfo_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                emu.grasscutter.net.proto.EffigyChallengeV2SettleInfoOuterClass.EffigyChallengeV2SettleInfo.class, emu.grasscutter.net.proto.EffigyChallengeV2SettleInfoOuterClass.EffigyChallengeV2SettleInfo.Builder.class);
      }

      // Construct using emu.grasscutter.net.proto.EffigyChallengeV2SettleInfoOuterClass.EffigyChallengeV2SettleInfo.newBuilder()
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
        challengeModeDifficulty_ = 0;

        unk3300MHOIIPJKAMN_ = 0;

        unk3300PHEIMLOKIJG_ = 0;

        unk3300ONKPGFOLDFL_ = 0;

        unk3300NGBKNDHJPCP_ = false;

        unk3300AKMPCDIKBJD_ = false;

        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return emu.grasscutter.net.proto.EffigyChallengeV2SettleInfoOuterClass.internal_static_EffigyChallengeV2SettleInfo_descriptor;
      }

      @java.lang.Override
      public emu.grasscutter.net.proto.EffigyChallengeV2SettleInfoOuterClass.EffigyChallengeV2SettleInfo getDefaultInstanceForType() {
        return emu.grasscutter.net.proto.EffigyChallengeV2SettleInfoOuterClass.EffigyChallengeV2SettleInfo.getDefaultInstance();
      }

      @java.lang.Override
      public emu.grasscutter.net.proto.EffigyChallengeV2SettleInfoOuterClass.EffigyChallengeV2SettleInfo build() {
        emu.grasscutter.net.proto.EffigyChallengeV2SettleInfoOuterClass.EffigyChallengeV2SettleInfo result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public emu.grasscutter.net.proto.EffigyChallengeV2SettleInfoOuterClass.EffigyChallengeV2SettleInfo buildPartial() {
        emu.grasscutter.net.proto.EffigyChallengeV2SettleInfoOuterClass.EffigyChallengeV2SettleInfo result = new emu.grasscutter.net.proto.EffigyChallengeV2SettleInfoOuterClass.EffigyChallengeV2SettleInfo(this);
        result.challengeModeDifficulty_ = challengeModeDifficulty_;
        result.unk3300MHOIIPJKAMN_ = unk3300MHOIIPJKAMN_;
        result.unk3300PHEIMLOKIJG_ = unk3300PHEIMLOKIJG_;
        result.unk3300ONKPGFOLDFL_ = unk3300ONKPGFOLDFL_;
        result.unk3300NGBKNDHJPCP_ = unk3300NGBKNDHJPCP_;
        result.unk3300AKMPCDIKBJD_ = unk3300AKMPCDIKBJD_;
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
        if (other instanceof emu.grasscutter.net.proto.EffigyChallengeV2SettleInfoOuterClass.EffigyChallengeV2SettleInfo) {
          return mergeFrom((emu.grasscutter.net.proto.EffigyChallengeV2SettleInfoOuterClass.EffigyChallengeV2SettleInfo)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(emu.grasscutter.net.proto.EffigyChallengeV2SettleInfoOuterClass.EffigyChallengeV2SettleInfo other) {
        if (other == emu.grasscutter.net.proto.EffigyChallengeV2SettleInfoOuterClass.EffigyChallengeV2SettleInfo.getDefaultInstance()) return this;
        if (other.getChallengeModeDifficulty() != 0) {
          setChallengeModeDifficulty(other.getChallengeModeDifficulty());
        }
        if (other.getUnk3300MHOIIPJKAMN() != 0) {
          setUnk3300MHOIIPJKAMN(other.getUnk3300MHOIIPJKAMN());
        }
        if (other.getUnk3300PHEIMLOKIJG() != 0) {
          setUnk3300PHEIMLOKIJG(other.getUnk3300PHEIMLOKIJG());
        }
        if (other.getUnk3300ONKPGFOLDFL() != 0) {
          setUnk3300ONKPGFOLDFL(other.getUnk3300ONKPGFOLDFL());
        }
        if (other.getUnk3300NGBKNDHJPCP() != false) {
          setUnk3300NGBKNDHJPCP(other.getUnk3300NGBKNDHJPCP());
        }
        if (other.getUnk3300AKMPCDIKBJD() != false) {
          setUnk3300AKMPCDIKBJD(other.getUnk3300AKMPCDIKBJD());
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
        emu.grasscutter.net.proto.EffigyChallengeV2SettleInfoOuterClass.EffigyChallengeV2SettleInfo parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (emu.grasscutter.net.proto.EffigyChallengeV2SettleInfoOuterClass.EffigyChallengeV2SettleInfo) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private int challengeModeDifficulty_ ;
      /**
       * <code>uint32 challenge_mode_difficulty = 13;</code>
       * @return The challengeModeDifficulty.
       */
      @java.lang.Override
      public int getChallengeModeDifficulty() {
        return challengeModeDifficulty_;
      }
      /**
       * <code>uint32 challenge_mode_difficulty = 13;</code>
       * @param value The challengeModeDifficulty to set.
       * @return This builder for chaining.
       */
      public Builder setChallengeModeDifficulty(int value) {
        
        challengeModeDifficulty_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>uint32 challenge_mode_difficulty = 13;</code>
       * @return This builder for chaining.
       */
      public Builder clearChallengeModeDifficulty() {
        
        challengeModeDifficulty_ = 0;
        onChanged();
        return this;
      }

      private int unk3300MHOIIPJKAMN_ ;
      /**
       * <code>uint32 Unk3300_MHOIIPJKAMN = 14;</code>
       * @return The unk3300MHOIIPJKAMN.
       */
      @java.lang.Override
      public int getUnk3300MHOIIPJKAMN() {
        return unk3300MHOIIPJKAMN_;
      }
      /**
       * <code>uint32 Unk3300_MHOIIPJKAMN = 14;</code>
       * @param value The unk3300MHOIIPJKAMN to set.
       * @return This builder for chaining.
       */
      public Builder setUnk3300MHOIIPJKAMN(int value) {
        
        unk3300MHOIIPJKAMN_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>uint32 Unk3300_MHOIIPJKAMN = 14;</code>
       * @return This builder for chaining.
       */
      public Builder clearUnk3300MHOIIPJKAMN() {
        
        unk3300MHOIIPJKAMN_ = 0;
        onChanged();
        return this;
      }

      private int unk3300PHEIMLOKIJG_ ;
      /**
       * <code>uint32 Unk3300_PHEIMLOKIJG = 11;</code>
       * @return The unk3300PHEIMLOKIJG.
       */
      @java.lang.Override
      public int getUnk3300PHEIMLOKIJG() {
        return unk3300PHEIMLOKIJG_;
      }
      /**
       * <code>uint32 Unk3300_PHEIMLOKIJG = 11;</code>
       * @param value The unk3300PHEIMLOKIJG to set.
       * @return This builder for chaining.
       */
      public Builder setUnk3300PHEIMLOKIJG(int value) {
        
        unk3300PHEIMLOKIJG_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>uint32 Unk3300_PHEIMLOKIJG = 11;</code>
       * @return This builder for chaining.
       */
      public Builder clearUnk3300PHEIMLOKIJG() {
        
        unk3300PHEIMLOKIJG_ = 0;
        onChanged();
        return this;
      }

      private int unk3300ONKPGFOLDFL_ ;
      /**
       * <code>uint32 Unk3300_ONKPGFOLDFL = 12;</code>
       * @return The unk3300ONKPGFOLDFL.
       */
      @java.lang.Override
      public int getUnk3300ONKPGFOLDFL() {
        return unk3300ONKPGFOLDFL_;
      }
      /**
       * <code>uint32 Unk3300_ONKPGFOLDFL = 12;</code>
       * @param value The unk3300ONKPGFOLDFL to set.
       * @return This builder for chaining.
       */
      public Builder setUnk3300ONKPGFOLDFL(int value) {
        
        unk3300ONKPGFOLDFL_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>uint32 Unk3300_ONKPGFOLDFL = 12;</code>
       * @return This builder for chaining.
       */
      public Builder clearUnk3300ONKPGFOLDFL() {
        
        unk3300ONKPGFOLDFL_ = 0;
        onChanged();
        return this;
      }

      private boolean unk3300NGBKNDHJPCP_ ;
      /**
       * <code>bool Unk3300_NGBKNDHJPCP = 5;</code>
       * @return The unk3300NGBKNDHJPCP.
       */
      @java.lang.Override
      public boolean getUnk3300NGBKNDHJPCP() {
        return unk3300NGBKNDHJPCP_;
      }
      /**
       * <code>bool Unk3300_NGBKNDHJPCP = 5;</code>
       * @param value The unk3300NGBKNDHJPCP to set.
       * @return This builder for chaining.
       */
      public Builder setUnk3300NGBKNDHJPCP(boolean value) {
        
        unk3300NGBKNDHJPCP_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>bool Unk3300_NGBKNDHJPCP = 5;</code>
       * @return This builder for chaining.
       */
      public Builder clearUnk3300NGBKNDHJPCP() {
        
        unk3300NGBKNDHJPCP_ = false;
        onChanged();
        return this;
      }

      private boolean unk3300AKMPCDIKBJD_ ;
      /**
       * <code>bool Unk3300_AKMPCDIKBJD = 9;</code>
       * @return The unk3300AKMPCDIKBJD.
       */
      @java.lang.Override
      public boolean getUnk3300AKMPCDIKBJD() {
        return unk3300AKMPCDIKBJD_;
      }
      /**
       * <code>bool Unk3300_AKMPCDIKBJD = 9;</code>
       * @param value The unk3300AKMPCDIKBJD to set.
       * @return This builder for chaining.
       */
      public Builder setUnk3300AKMPCDIKBJD(boolean value) {
        
        unk3300AKMPCDIKBJD_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>bool Unk3300_AKMPCDIKBJD = 9;</code>
       * @return This builder for chaining.
       */
      public Builder clearUnk3300AKMPCDIKBJD() {
        
        unk3300AKMPCDIKBJD_ = false;
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


      // @@protoc_insertion_point(builder_scope:EffigyChallengeV2SettleInfo)
    }

    // @@protoc_insertion_point(class_scope:EffigyChallengeV2SettleInfo)
    private static final emu.grasscutter.net.proto.EffigyChallengeV2SettleInfoOuterClass.EffigyChallengeV2SettleInfo DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new emu.grasscutter.net.proto.EffigyChallengeV2SettleInfoOuterClass.EffigyChallengeV2SettleInfo();
    }

    public static emu.grasscutter.net.proto.EffigyChallengeV2SettleInfoOuterClass.EffigyChallengeV2SettleInfo getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<EffigyChallengeV2SettleInfo>
        PARSER = new com.google.protobuf.AbstractParser<EffigyChallengeV2SettleInfo>() {
      @java.lang.Override
      public EffigyChallengeV2SettleInfo parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new EffigyChallengeV2SettleInfo(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<EffigyChallengeV2SettleInfo> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<EffigyChallengeV2SettleInfo> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public emu.grasscutter.net.proto.EffigyChallengeV2SettleInfoOuterClass.EffigyChallengeV2SettleInfo getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_EffigyChallengeV2SettleInfo_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_EffigyChallengeV2SettleInfo_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n!EffigyChallengeV2SettleInfo.proto\"\321\001\n\033" +
      "EffigyChallengeV2SettleInfo\022!\n\031challenge" +
      "_mode_difficulty\030\r \001(\r\022\033\n\023Unk3300_MHOIIP" +
      "JKAMN\030\016 \001(\r\022\033\n\023Unk3300_PHEIMLOKIJG\030\013 \001(\r" +
      "\022\033\n\023Unk3300_ONKPGFOLDFL\030\014 \001(\r\022\033\n\023Unk3300" +
      "_NGBKNDHJPCP\030\005 \001(\010\022\033\n\023Unk3300_AKMPCDIKBJ" +
      "D\030\t \001(\010B\033\n\031emu.grasscutter.net.protob\006pr" +
      "oto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_EffigyChallengeV2SettleInfo_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_EffigyChallengeV2SettleInfo_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_EffigyChallengeV2SettleInfo_descriptor,
        new java.lang.String[] { "ChallengeModeDifficulty", "Unk3300MHOIIPJKAMN", "Unk3300PHEIMLOKIJG", "Unk3300ONKPGFOLDFL", "Unk3300NGBKNDHJPCP", "Unk3300AKMPCDIKBJD", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
