package frc.team967.robot.commands.auto;

import frc.team967.lib.util.MatchData;
import frc.team967.robot.commands.DriveStright;
import frc.team967.robot.commands.auto.subMain.A_RedRight_LLL;
import frc.team967.robot.commands.auto.subMain.A_RedRight_LRL;
import frc.team967.robot.commands.auto.subMain.A_RedRight_RLR;
import frc.team967.robot.commands.auto.subMain.A_RedRight_RRR;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class A_RedRight extends CommandGroup {

    public A_RedRight() {

		addSequential(new AutoStartUpResets());

		addSequential(new DriveStright(390*9,.5));

		addSequential(new AutoEndResets());

//    	MatchData.OwnedSide positionOne = MatchData.getOwnedSide(MatchData.GameFeature.SWITCH_NEAR);
//    	MatchData.OwnedSide positionTwo = MatchData.getOwnedSide(MatchData.GameFeature.SCALE);
//    	MatchData.OwnedSide positionThree = MatchData.getOwnedSide(MatchData.GameFeature.SWITCH_NEAR);
//
//    	if (positionOne == MatchData.OwnedSide.LEFT && positionTwo == MatchData.OwnedSide.LEFT && positionThree == MatchData.OwnedSide.LEFT) {
//    		addSequential(new A_RedRight_LLL());
//    	}
//    	else if (positionOne == MatchData.OwnedSide.RIGHT && positionTwo == MatchData.OwnedSide.LEFT && positionOne == MatchData.OwnedSide.RIGHT) {
//    		addSequential(new A_RedRight_RLR());
//    	}
//    	else if (positionOne == MatchData.OwnedSide.LEFT && positionTwo == MatchData.OwnedSide.RIGHT && positionThree == MatchData.OwnedSide.LEFT) {
//    		addSequential(new A_RedRight_LRL());
//    	}
//    	else if (positionOne == MatchData.OwnedSide.RIGHT && positionTwo == MatchData.OwnedSide.RIGHT && positionThree == MatchData.OwnedSide.RIGHT) {
//    		addSequential(new A_RedRight_RRR());
//    	}
    }
}
