package fractal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class OrderDownButton extends JButton implements ActionListener {
    private FractalView view;

    public OrderDownButton(FractalView view) {
        super("<");
        this.view = view;
        addActionListener(this);
        this.setToolTipText("Minskar fraktalens ordning.");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Fractal fractal = view.getFractal();
        if (fractal.getOrder() > 0) {
            fractal.setOrder(fractal.order - 1);
            view.updateDrawing();
        }
    }

}
