package com.tlias.utils;

public class ThreadLocalUtils {

    private static final ThreadLocal<Integer> currentId = new ThreadLocal<>();

    public static void setCurrentId(Integer id) {
        currentId.set(id);
    }

    public static Integer getCurrentId() {
        return currentId.get();
    }

    public static void removeCurrentId() {
        currentId.remove();
    }

    private static ThreadLocal<String> currentUsername = new ThreadLocal<>();

    public static void setCurrentUsername(String username) {
        currentUsername.set(username);
    }
    public static String getCurrentUsername() {
        return currentUsername.get();
    }

    public static void removeCurrentUsername() {
        currentUsername.remove();
    }

    private static ThreadLocal<String> currentName = new ThreadLocal<>();

    public static void setCurrentName(String name) {
        currentName.set(name);
    }
    public static String getCurrentName() {
        return currentName.get();
    }

    public static void removeCurrentName() {
        currentName.remove();
    }

    private static ThreadLocal<String> currentPassword = new ThreadLocal<>();

    public static void setCurrentPassword(String password) {
        currentPassword.set(password);
    }
    public static String getCurrentPassword() {
        return currentPassword.get();
    }

    public static void removeCurrentPassword() {
        currentPassword.remove();
    }

}
