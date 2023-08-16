package com.justbelieveinmyself.Hangman;

public enum HangingStatus {
    ZERO{
        @Override
        public String toString(){
            return "";
        }
    },
    ONE{
        @Override
        public String toString(){
            return """
                |
                |
                |
                |
                |
                |""";
        }
    },
    TWO{
        @Override
        public String toString(){
            return """
                ________
                |/
                |
                |
                |
                |""";
        }
    },
    THREE{
        @Override
        public String toString(){
            return """
                ________
                |/    |
                |
                |
                |
                |""";
        }
    },
    FOUR{
        @Override
        public String toString(){
            return """
                ________
                |/    |
                |     *
                |     |
                |     |
                |""";
        }
    },
    FIVE{
        @Override
        public String toString(){
            return """
                ________
                |/    |
                |     *
                |    /|\\
                |     |
                |""";
        }
    },
    SIX{
        @Override
        public String toString(){
            return """
                ________
                |/    |
                |     *
                |    /|\\
                |    /-\\
                |""";
        }
    };
}