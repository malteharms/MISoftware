package de.malteharms.libmi;


public final class Native {

    static {
        System.loadLibrary("mi_jni");
    }

    private Native() {}

    public static native byte[] encrypt(byte[] jptext, byte[] jkey);
    public static native byte[] decrypt(byte[] jctext, byte[] jkey);
    public static native String sha256(String input);
    public static native byte[] generateKeyPair();
    public static native byte[] calculateECDHE(byte[] ourPrivateKey, byte[] theirPublicKey);

}
