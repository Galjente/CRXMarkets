package eu.galjente.crxmarkets;

import javax.ejb.Stateless;
import java.io.Serializable;
import java.util.List;

@Stateless
public class RainyHillsService implements Serializable {

	/**
	 * Returns water volume based on hill heights.
	 * <br/>
	 * Hill heights should be >= 0
	 * <p>
	 * 	We can find amount of water to be stored in every element by
	 *  finding the heights of hill on left and right sides.
	 *  The idea is to compute amount of water that can be stored in every element of array.
	 *	<br/>
	 *	Main idea is to prre-compute highest hill on left and right of every bar in O(n) time.
	 *	Then use these pre-computed values to find the amount of water in every array element.
	 * </p>
	 *
	 * @param hillHeights array with hill heights >= 0
	 * @return water volume
	 */
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
