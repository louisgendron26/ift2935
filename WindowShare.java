
						Object[][] rows = {
							    {"element","symbol","atomicNumber","atomicMass","valence"},
							    {"element","symbol","atomicNumber","atomicMass","valence"}
							};
							Object[] cols = {
							    "ID","Price","ShareTime","Type", "avaible"
							};
							JTable table = new JTable(rows, cols);
							JOptionPane.showMessageDialog(null, new JScrollPane(table), "Results", JOptionPane.INFORMATION_MESSAGE);
