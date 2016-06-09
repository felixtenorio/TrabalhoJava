package br.univel;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class ProdutoModel extends AbstractTableModel {

	private List<Produto> lista;

	public ProdutoModel(List<Produto> lista) {
		this.lista = lista;
	}

	@Override
	public int getColumnCount() {
		return 3;
	}

	@Override
	public int getRowCount() {
		return lista.size();
	}

	@Override
	public Object getValueAt(int row, int col) {

		Produto b = lista.get(row);

		switch (col) {
		case 0:
			return b.getId();
		case 1:
			return b.getDescricao();
		case 2:
			return b.getPreco();
		}

		return null;
	}

	public Produto getClienteNaLinha(int index) {
		return lista.get(index);
	}

	public void removerCliente(Produto b) {
		int idx = this.lista.indexOf(b);
		this.lista.remove(b);
		super.fireTableRowsDeleted(idx, idx);
	}

	public void adicionarCliente(Produto b) {
		this.lista.add(b);
		super.fireTableRowsInserted(lista.size() - 1, lista.size() - 1);

	}

}
