package eu.galjente.crxmarkets;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SessionScoped
@Named
public class RainyHillsBean implements Serializable {

	private Integer hillHeight;
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

	public void add() {
		hills.add(hillHeight);
		hillHeight = null;
	}

	public void delete(int index) {
		hills.remove(index);
	}
}
