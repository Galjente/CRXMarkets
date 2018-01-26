package eu.galjente.crxmarkets;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SessionScoped
@Named
public class RainyHillsBean implements Serializable {

	@Inject
	protected RainyHillsService rainyHillsService;

	/**
	 * Contains input from JSF page
	 */
	private Integer hillHeight;

	/**
	 * Contains water volume calculation
	 */
	private Integer waterVolume = 0;

	/**
	 * Contains submitted hills heights
	 */
	private List<Integer> hills = new ArrayList<>();

	public List<Integer> getHills() {
		return hills;
	}

	public void setHills(List<Integer> hills) {
		this.hills = hills;
	}

	public Integer getHillHeight() {
		return hillHeight;
	}

	public void setHillHeight(Integer hillHeight) {
		this.hillHeight = hillHeight;
	}

	public Integer getWaterVolume() {
		return waterVolume;
	}

	public void setWaterVolume(Integer waterVolume) {
		this.waterVolume = waterVolume;
	}

	/**
	 * Add hill height to {@link RainyHillsBean#hills} array, cleaning {@link RainyHillsBean#hillHeight} value and
	 * executing {@link RainyHillsService#calculate} method with current hills.
	 * <br/><br/>
	 * Nothing will happens if {@link RainyHillsBean#hillHeight} is null or {@link RainyHillsBean#hillHeight} is negative.
	 */
	public void add() {
		if (hillHeight != null && hillHeight >= 0) {
			hills.add(hillHeight);
			waterVolume = rainyHillsService.calculate(hills);
		}
		hillHeight = null;
	}

	/**
	 * Removing hill height from {@link RainyHillsBean#hills} array and
	 * executing {@link RainyHillsService#calculate} method with current hills.
	 * <br/><br/>
	 * Nothing will happens if position outside of {@link RainyHillsBean#hills} array bands.
	 *
	 * @param index hill position in array
	 */
	public void delete(int index) {
		if (index >= 0 && index < hills.size()) {
			hills.remove(index);
			waterVolume = rainyHillsService.calculate(hills);
		}
	}
}
