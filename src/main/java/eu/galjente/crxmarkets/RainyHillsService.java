package eu.galjente.crxmarkets;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class RainyHillsService {

	public Integer calculate(List<Integer> hillHeights) {
		int waterVolume = 0;
		int leftHillMaxHeight = 0;
		int rightHillMaxPosition = 0;
		int leftHillPosition = 0;
		int rightHillPosition = hillHeights.size()-1;

		while (leftHillPosition <= rightHillPosition) {
			if (hillHeights.get(leftHillPosition) < hillHeights.get(rightHillPosition)) {
				if (hillHeights.get(leftHillPosition) > leftHillMaxHeight) {
					leftHillMaxHeight = hillHeights.get(leftHillPosition);
				} else {
					waterVolume += leftHillMaxHeight - hillHeights.get(leftHillPosition);
				}
				leftHillPosition++;
			} else {
				if (hillHeights.get(rightHillPosition) > rightHillMaxPosition) {
					rightHillMaxPosition = hillHeights.get(rightHillPosition);
				} else {
					waterVolume += rightHillMaxPosition - hillHeights.get(rightHillPosition);
				}
				rightHillPosition--;
			}
		}

		return waterVolume;
	}
}
