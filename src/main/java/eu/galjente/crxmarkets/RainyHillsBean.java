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

	private Integer hillHeight;
	private Integer waterVolume = 0;
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

	public void add() {
		hills.add(hillHeight);
		hillHeight = null;
		waterVolume = rainyHillsService.calculate(hills);
	}

	public void delete(int index) {
		hills.remove(index);
	}
}
