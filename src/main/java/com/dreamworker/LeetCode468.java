package com.dreamworker;

public class LeetCode468 {

    public static void main(String[] args) {
        LeetCode468 solution = new LeetCode468();
        System.out.println(solution.validIPAddress("0.0.0.256"));
    }

    public String validIPAddress(String IP) {
        if (IP.indexOf(':') != -1) {
            return validIPv6Address(IP) ? "IPv6" : "Neither";
        } else {
            return validIPv4Address(IP) ? "IPv4" : "Neither";
        }
    }

    public boolean validIPv6Address(String IP) {
        int parts = 0;
        int index = IP.indexOf(':');
        int start = 0;
        while (index != -1) {
            String item = IP.substring(start, index);
            if (item.length() <= 0 || item.length() > 4) {
                return false;
            }
            for (int i = 0; i < item.length(); i++) {
                if (!isHexChar(item.charAt(i))) {
                    return false;
                }
            }
            start = index + 1;
            index = IP.indexOf(':', start);
            parts++;
        }

        if (parts == 7) {
            String item = IP.substring(start);
            if (item.length() > 0 && item.length() <= 4) {
                int i;
                for (i = 0; i < item.length(); i++) {
                    if (!isHexChar(item.charAt(i))) {
                        break;
                    }
                }
                if (i == 4) {
                    parts++;
                }
            }
        }

        return parts == 8;
    }

    public boolean isHexChar(char c) {
        return c >= '0' && c <= '9' || c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z';
    }

    public boolean validIPv4Address(String IP) {
        int parts = 0;
        int index = IP.indexOf('.');
        int start = 0;
        while (index != -1) {
            String item = IP.substring(start, index);
            try {
                int number = Integer.parseInt(item);
                if (number < 0 || number >255) {
                    return false;
                }
                start = index + 1;
                index = IP.indexOf('.', start);
                parts++;
            } catch (Exception e) {
                return false;
            }
        }

        if (parts == 3) {
            String item = IP.substring(start);
            try {
                int number = Integer.parseInt(item);
                if (number >= 0 || number <= 255) {
                    parts++;
                }
            } catch (Exception e) {
                return false;
            }
        }

        return parts == 4;
    }
}
