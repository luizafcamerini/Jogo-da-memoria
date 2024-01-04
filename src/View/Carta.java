package View;

import Observer.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.*;

class Carta extends JPanel implements MouseListener, Observador, Observado {
	private int x, y, w = 90, h = 170;
	private Color corSelecionada = new Color(248, 117, 170);
	private Color corDeselecionada = new Color(174, 222, 252);
	private Color corSimbolos = new Color(248, 117, 170);
	private Color corPreenchimento = Color.white;
	private Color corBorda = corDeselecionada;
	private boolean selecionada = false;
	private boolean descoberta = false;
	private String simbolo;
	private Observador observador;

	/* Esse status é usado no model para definir a visualização da carta. */
	private final int STATUS_ESCONDIDA = 0;
	private final int STATUS_SELECIONADA = 1;
	private final int STATUS_DESCOBERTA = 2;
	private int status = STATUS_ESCONDIDA;

	public Carta(int x, int y, String simbolo) {
		this.x = x;
		this.y = y;
		this.simbolo = simbolo;
		setBounds(x, y, w, h);
		addMouseListener(this);
	}

	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		RoundRectangle2D.Double r = new RoundRectangle2D.Double(0, 0, w, h, 20, 20);
		g2d.setColor(corPreenchimento);
		g2d.fill(r);
		if (selecionada) {
			corBorda = corSelecionada;
		} else {
			corBorda = corDeselecionada;
		}
		g2d.setColor(corBorda);
		g2d.setStroke(new BasicStroke(15));
		g2d.draw(r);
		desenhaSimbolo(g2d);
	}

	private void desenhaSimbolo(Graphics2D g2d) {
		if (!descoberta) {
			if (!selecionada) {
				return;
			}
		}
		g2d.setColor(corSimbolos);
		int raio = 50;
		int xCentro = w / 2 - (raio / 2);
		int yCentro = h / 2 - (raio / 2);
		switch (this.simbolo) {
			case "CIRCULO":
				Ellipse2D.Double e = new Ellipse2D.Double(xCentro, yCentro, raio, raio);
				g2d.fill(e);
				break;

			case "QUADRADO":
				Rectangle2D.Double quadrado = new Rectangle2D.Double(w / 4, h / 3, w / 2, w / 2);
				g2d.fill(quadrado);
				break;

			case "TRIANGULO":
				Path2D triangulo = new Path2D.Double();
				double lado = h / 4 * 0.8; // Comprimento do lado do triângulo (80% do menor lado)
				double x1 = (w - lado) / 2;
				double y1 = h / 2 + (Math.sqrt(3) / 6) * lado;

				double x2 = x1 + lado / 2;
				double y2 = y1 - (Math.sqrt(3) / 3) * lado;

				double x3 = x1 + lado;
				double y3 = y1;

				triangulo.moveTo(x1, y1);
				triangulo.lineTo(x2, y2);
				triangulo.lineTo(x3, y3);
				triangulo.closePath();
				g2d.draw(triangulo);
				g2d.fill(triangulo);
				break;

			case "RETANGULO":
				Rectangle2D.Double retangulo = new Rectangle2D.Double(w / 4, h / 4, w / 2, h / 2);
				g2d.fill(retangulo);
				break;

			case "CRUZ":
				Path2D cruz = new Path2D.Double();
				int tamBraco = 20; // Tamanho do braco da cruz

				double CRUZx1 = w / 2 - tamBraco; // Ponto esquerdo
				double CRUZy1 = h / 2;

				double CRUZx2 = w / 2 + tamBraco; // Ponto direito
				double CRUZy2 = h / 2;

				double CRUZx3 = w / 2; // Ponto superior
				double CRUZy3 = h / 2 - tamBraco;

				double CRUZx4 = w / 2; // Ponto inferior
				double CRUZy4 = h / 2 + tamBraco;

				cruz.moveTo(CRUZx1, CRUZy1);
				cruz.lineTo(CRUZx2, CRUZy2);
				cruz.moveTo(CRUZx3, CRUZy3);
				cruz.lineTo(CRUZx4, CRUZy4);
				g2d.draw(cruz);
				break;

			case "LOSANGO":
				Path2D losango = new Path2D.Double();

				double LOSx1 = w / 2; // Ponto superior
				double LOSy1 = h / 3;

				double LOSx2 = 3 * (w / 4); // Ponto direito
				double LOSy2 = h / 2;

				double LOSx3 = w / 2; // Ponto inferior
				double LOSy3 = 2 * (h / 3);

				double LOSx4 = w / 4; // Ponto esquerdo
				double LOSy4 = h / 2;

				losango.moveTo(LOSx1, LOSy1);
				losango.lineTo(LOSx2, LOSy2);
				losango.lineTo(LOSx3, LOSy3);
				losango.lineTo(LOSx4, LOSy4);
				losango.closePath();
				g2d.fill(losango);
				g2d.draw(losango);
				break;

			case "CORACAO":
				GeneralPath coracao = new GeneralPath();
				coracao.moveTo(w / 2, h / 2 + w / 4);

				// Desenha a metade esquerda do coração
				coracao.curveTo(
						0, h / 2 - w / 4,
						w / 4, h / 2 - w / 2,
						w / 2, h / 2 - w / 4);

				// Desenha a metade direita do coração
				coracao.curveTo(
						w / 2 + w / 4, h / 2 - w / 2,
						w, h / 2 - w / 4,
						w / 2, h / 2 + w / 4);

				g2d.fill(coracao);
				break;

			default:
				break;
		}
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public String getSimbolo() {
		return this.simbolo;
	}

	public void mouseClicked(MouseEvent e) {
		if (!descoberta) {
			this.selecionada = !selecionada;
			repaint();
		}
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
		if (!selecionada) {
			this.corPreenchimento = new Color(255, 246, 246);
		}
		repaint();
	}

	public void mouseExited(MouseEvent e) {
		if (!selecionada) {
			this.corPreenchimento = Color.white;
		}
		repaint();
	}

	public void setSelecionada(boolean b) {
		this.selecionada = b;
	}

	public void addObservador(Observador o) {
		this.observador = o;
	}

	public void removeObservador(Observador o) {
		this.observador = null;
	}

	public int get(int i){
		return 0;
	}

	public void notify(Observado o){
		repaint();
	}

	public void notificaObservador(Observado o) {
		o.notify();
	}

}
