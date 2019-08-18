package primitives;

public class AdvamncedNaming {

    //UNDERSCORE
    //int this-is-not-ok;
    int this_is_ok;
    //int _; //one underscore is not ok
    int __;  //two underscores is ok
    int he________________, ______________; //still ok!
    int ______0_________________; //still ok!
    //int 0_; // you can't start with a number

    //NAMING IS CASE SENSITIVE
    int A = 4;
    int a = 5; //a != A

    //NUMBER
    //int 5_; this is not ok
    int _5; // this is!!!

    //DOLLAR SIGN
    int $;
    int $$;
    int $$$;
    int _$_____$_;
    int __$$$__;
    int _$$$_;
    int $hello, $_hello, _hello, _hello$, he$llo;
    //int _;  //Error:(6, 9) java: as of release 9, '_' is a keyword, and may not be used as an identifier
    int he$$$$$$lo, he$________$lo;

}