package org.primefaces.test;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named("mvceCtlr")
@SessionScoped
public class MvceController implements Serializable {
	private static final long serialVersionUID = 1L;

	protected List<MvceModel> models;
	
	protected List<MvceModel> selections;
	
	private String text;
	
	protected List<MvceModel> source;
	
	public MvceController() {
		// nothing
	}
	
	@PostConstruct
	public void init() {
		source = new LinkedList<MvceModel>() {
			private static final long serialVersionUID = 1L;
			{
				add(new MvceModel(1, "OPEN", "Car"));
				add(new MvceModel(2, "OPEN", "Bike"));
				add(new MvceModel(3, "OPEN", "Truck"));
				add(new MvceModel(4, "CLOSED", "Trolley"));
				add(new MvceModel(5, "OPEN", "Train"));
				add(new MvceModel(6, "CLOSED", "Car"));
				add(new MvceModel(7, "OPEN", "Scooty"));
			}
		};
		models = source;
	}

	public void changeTxnStatus(String status) {
		selections.forEach(record -> record.setStatus(status));
		selections = null;
	}

	public List<MvceModel> getSelections() {
		return selections;
	}

	public void setSelections(List<MvceModel> selections) {
		this.selections = selections;
	}

	public List<MvceModel> getModels() {
		return models;
	}
	
	public String changeStatusLabel() {
		if (selections.size() == 1) {
			return selections.size() + " row selected";
		}
		return selections.size() + " rows selected";
	}
	
	public void filter() {
		System.out.println("text >>>> " + text);
		if (text.equalsIgnoreCase("all")) {
			models = source;
			return;
		}
		models = source.stream()
					.filter(item -> item.getType().equalsIgnoreCase(text))
					.collect(Collectors.toList());
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
