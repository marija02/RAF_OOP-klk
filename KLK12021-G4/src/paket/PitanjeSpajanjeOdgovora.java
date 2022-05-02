package paket;

import java.util.ArrayList;
import java.util.List;

public class PitanjeSpajanjeOdgovora extends Pitanje{

    public PitanjeSpajanjeOdgovora(String tekstPitanja) {
        super(tekstPitanja);
    }

    /// 1 2 3
    /// 3 5 6
    @Override /// 1:3,2:5,3:6
    public int brojPoena(String str) {
        return 0;
    }
}
