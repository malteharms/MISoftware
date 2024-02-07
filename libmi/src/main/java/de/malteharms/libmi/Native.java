package de.malteharms.libmi;


public final class Native {

    static {
        System.loadLibrary("mi_jni");
    }

    private Native() {}

    public static native Byte[] encrypt(Byte[] input);
    public static native Byte[] decrypt(Byte[] cipher);
    public static native Byte[] sha256(Byte[] input);
    public static native Byte[] generateKeyPair();
    public static native Byte[] calculateECDHE(Byte[] ourPrivateKey, Byte[] theirPublicKey);

}
