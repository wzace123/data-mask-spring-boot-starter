package org.wz.datamask.util;

public class StringUtil {

    public static String maskStr(String str,int front,int end) {
        if (!isBlank(str) && front + end < str.length()) {
            return front >= 0 && end >= 0 ? hide(str, front, str.length() - end) : "";
        }
        return "";
    }

    public static String hide(CharSequence str, int startInclude, int endExclude) {
        return replace(str, startInclude, endExclude, '*');
    }

    public static String replace(CharSequence str, int startInclude, int endExclude, char replacedChar) {
        if (isEmpty(str)) {
            return str(str);
        } else {
            int strLength = str.length();
            if (startInclude > strLength) {
                return str(str);
            } else {
                if (endExclude > strLength) {
                    endExclude = strLength;
                }

                if (startInclude > endExclude) {
                    return str(str);
                } else {
                    char[] chars = new char[strLength];

                    for(int i = 0; i < strLength; ++i) {
                        if (i >= startInclude && i < endExclude) {
                            chars[i] = replacedChar;
                        } else {
                            chars[i] = str.charAt(i);
                        }
                    }

                    return new String(chars);
                }
            }
        }
    }

    public static int indexOf(CharSequence seq, int searchChar) {
        return isEmpty(seq) ? -1 : indexOf(seq, searchChar, 0);
    }

    public static int indexOf(final CharSequence cs, final int searchChar, int start) {
        if (cs instanceof String) {
            return ((String)cs).indexOf(searchChar, start);
        } else {
            int sz = cs.length();
            if (start < 0) {
                start = 0;
            }

            for(int i = start; i < sz; ++i) {
                if (cs.charAt(i) == searchChar) {
                    return i;
                }
            }

            return -1;
        }
    }

    public static boolean isEmpty(CharSequence cs) {
        return cs == null || cs.length() == 0;
    }

    public static String str(CharSequence cs) {
        return cs == null ? null : cs.toString();
    }

    public static String repeat(char c, int count) {
        if (count <= 0) {
            return "";
        } else {
            char[] result = new char[count];

            for(int i = 0; i < count; ++i) {
                result[i] = c;
            }
            return new String(result);
        }
    }

    public static boolean isBlank(CharSequence cs) {
        int strLen;
        if (cs != null && (strLen = cs.length()) != 0) {
            for(int i = 0; i < strLen; ++i) {
                if (!Character.isWhitespace(cs.charAt(i))) {
                    return false;
                }
            }
            return true;
        } else {
            return true;
        }
    }

    public static String trim(String str) {
        return str == null ? null : str.trim();
    }

}
