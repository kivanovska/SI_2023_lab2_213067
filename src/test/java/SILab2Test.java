import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SILab2Test {

    private final User user = new User("kristina","komp","kike@gmailcom");
    private List<User> createList(User...elems){
        return new ArrayList<>(Arrays.asList(elems));
    }
    @Test
    void EveryBranchAndException(){
        RuntimeException ex;
        ex=assertThrows(RuntimeException.class,()->SILab2.function(new User(null,null,null),createList(new User("kikeiv","kompjuter","kike@gmail.com"))));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

        //Ovaa proverka e za da vrati false od linija 20
        assertFalse(SILab2.function(user,createList(new User("kristina","komp12","kristina@gmail.com"),new User("kristina","komp22","kristina@gmail.com"))));

        //Ovaa proverka e za da vrati true koga ke se sporedat vrednostite na promenlivata same,linija 24
        assertTrue(SILab2.function(new User("kristina","kkkk@!$#%@","kikeiv@gmail.com"),createList(new User("marija","$$$kdkjejnc","kikeiv2@gmail.com"),new User("elena","hjdkeij$$$$","kikeiv3@gmail.com"))));

        //Ovaa proverka e za da vrati false koga passwordot ima prazno mesto na linija 26
        assertFalse(SILab2.function(new User("iva","prazno mesto","mkikeiv@gmail.com"),createList(new User("irena","fnsdjk fnsdk$%$%$%","kikeiv2@gmail.com"),new User("liljana","passs dssss *+,-./s","kristina@gmail.com"))));

        //Ovaa proverka e za da vrati false koga username e null, i passwordot nema specijalni znaci, linija 26
        assertFalse(SILab2.function(new User(null,"kompjuter","student@gmail.com"),createList(new User("ime","kompjuteeer","nestho@gmail.com"))));
    }

    @Test
    void MultipleCondition(){
        RuntimeException ex;

        // TXX
        ex=assertThrows(RuntimeException.class,()->SILab2.function(new User(null,null,null),createList(new User("marija","passsssss","student@gmail.com"))));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

        // FTX
        ex=assertThrows(RuntimeException.class,()->SILab2.function(new User("kristina113",null,"student@gmail.com"),createList(new User("marija","ppasssssss","nestho@gmail.com"))));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

        // FFT
        ex=assertThrows(RuntimeException.class,()->SILab2.function(new User("kristina113","bitola123",null),createList(new User("marija","ppasssssss","nestho@gmail.com"))));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

        // FFF
        assertTrue(SILab2.function(new User("marija","pass!$#%()@","marija123@gmail.com"),createList(new User("kristina","skopje$%$%$%","kike111@gmail.com"),new User("jovana","veles*+,-./s","jovanajov@gmail.com"))));
    }
}
