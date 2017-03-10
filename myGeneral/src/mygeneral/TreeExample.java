/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mygeneral;
//import pimport info.chrismcgee.sky.production.treetable.NoRootTreeTableModel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeCellRenderer;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

public class TreeExample {

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {

                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

                    //Create and set up the window.
                    JFrame frame = new JFrame("GenealogyExample");
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                    //Create and set up the content pane.
                    GenealogyExample newContentPane = new GenealogyExample();
                    newContentPane.setOpaque(true); //content panes must be opaque
                    frame.setContentPane(newContentPane);

                    //Display the window.
                    frame.pack();
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    public static class GenealogyExample extends JPanel
            implements ActionListener {

        private JTree tree;
        private static String SHOW_ANCESTOR_CMD = "showAncestor";

        public GenealogyExample() {
            super(new BorderLayout());

            //Construct the panel with the toggle buttons.
            JRadioButton showDescendant
                    = new JRadioButton("Show descendants", true);
            final JRadioButton showAncestor
                    = new JRadioButton("Show ancestors");
            ButtonGroup bGroup = new ButtonGroup();
            bGroup.add(showDescendant);
            bGroup.add(showAncestor);
            showDescendant.addActionListener(this);
            showAncestor.addActionListener(this);
            showAncestor.setActionCommand(SHOW_ANCESTOR_CMD);
            JPanel buttonPanel = new JPanel();
            buttonPanel.add(showDescendant);
            buttonPanel.add(showAncestor);

            //Construct the tree.
            tree = new JTree(new GenealogyModel(getGenealogyGraph()));
      tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
            tree.setCellRenderer(new CheckBoxTreeCellRenderer());

            JScrollPane scrollPane = new JScrollPane(tree);
            scrollPane.setPreferredSize(new Dimension(200, 200));

            //Add everything to this panel.
            add(buttonPanel, BorderLayout.PAGE_START);
            add(scrollPane, BorderLayout.CENTER);
        }

        /**
         * Required by the ActionListener interface. Handle events on the
         * showDescendant and showAncestore buttons.
         */
        public void actionPerformed(ActionEvent ae) {
            if (ae.getActionCommand() == SHOW_ANCESTOR_CMD) {
                showAncestor(true);
            } else {
                showAncestor(false);
            }
        }

        public void showAncestor(boolean b) {
        Object newRoot = null;
        TreePath path = tree.getSelectionModel().getSelectionPath();
        if (path != null) {
            newRoot = path.getLastPathComponent();
        }
        ((GenealogyModel)tree.getModel()).showAncestor(b, newRoot);
    }

        /**
         * Constructs the genealogy graph used by the model.
         */
        public Person getGenealogyGraph() {
            //the greatgrandparent generation
            Person a1 = new Person("Jack (great-granddaddy)");
            Person a2 = new Person("Jean (great-granny)");
            Person a3 = new Person("Albert (great-granddaddy)");
            Person a4 = new Person("Rae (great-granny)");
            Person a5 = new Person("Paul (great-granddaddy)");
            Person a6 = new Person("Josie (great-granny)");

            //the grandparent generation
            Person b1 = new Person("Peter (grandpa)");
            Person b2 = new Person("Zoe (grandma)");
            Person b3 = new Person("Simon (grandpa)");
            Person b4 = new Person("James (grandpa)");
            Person b5 = new Person("Bertha (grandma)");
            Person b6 = new Person("Veronica (grandma)");
            Person b7 = new Person("Anne (grandma)");
            Person b8 = new Person("Renee (grandma)");
            Person b9 = new Person("Joseph (grandpa)");

            //the parent generation
            Person c1 = new Person("Isabelle (mom)");
            Person c2 = new Person("Frank (dad)");
            Person c3 = new Person("Louis (dad)");
            Person c4 = new Person("Laurence (dad)");
            Person c5 = new Person("Valerie (mom)");
            Person c6 = new Person("Marie (mom)");
            Person c7 = new Person("Helen (mom)");
            Person c8 = new Person("Mark (dad)");
            Person c9 = new Person("Oliver (dad)");

            //the youngest generation
            Person d1 = new Person("Clement (boy)");
            Person d2 = new Person("Colin (boy)");

            Person.linkFamily(a1, a2, new Person[]{b1, b2, b3, b4});
            Person.linkFamily(a3, a4, new Person[]{b5, b6, b7});
            Person.linkFamily(a5, a6, new Person[]{b8, b9});
            Person.linkFamily(b3, b6, new Person[]{c1, c2, c3});
            Person.linkFamily(b4, b5, new Person[]{c4, c5, c6});
            Person.linkFamily(b8, b7, new Person[]{c7, c8, c9});
            Person.linkFamily(c4, c7, new Person[]{d1, d2});

            return a1;
        }

    }

    public static class CheckBoxTreeCellRenderer implements TreeCellRenderer {

        private JCheckBox cb = new JCheckBox();

        @Override
        public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus) {

            cb.setText(value.toString());
            cb.setOpaque(selected);
            if (selected) {
                cb.setBackground(UIManager.getColor("Tree.selectionBackground"));
                cb.setForeground(UIManager.getColor("Tree.selectionForeground"));
            } else {
                cb.setBackground(tree.getBackground());
                cb.setForeground(tree.getForeground());
            }

            return cb;

        }

    } 

    public static class GenealogyModel implements TreeModel {

        private boolean showAncestors;
        private Vector<TreeModelListener> treeModelListeners
                = new Vector<TreeModelListener>();
        private Person rootPerson;

        public GenealogyModel(Person root) {
            showAncestors = false;
            rootPerson = root;
        }

        /**
         * Used to toggle between show ancestors/show descendant and to change the
         * root of the tree.
         */
        public void showAncestor(boolean b, Object newRoot) {
            showAncestors = b;
            Person oldRoot = rootPerson;
            if (newRoot != null) {
                rootPerson = (Person) newRoot;
            }
            fireTreeStructureChanged(oldRoot);
        }

//////////////// Fire events //////////////////////////////////////////////
        /**
         * The only event raised by this model is TreeStructureChanged with the root
         * as path, i.e. the whole tree has changed.
         */
        protected void fireTreeStructureChanged(Person oldRoot) {
            int len = treeModelListeners.size();
            TreeModelEvent e = new TreeModelEvent(this,
                    new Object[]{oldRoot});
            for (TreeModelListener tml : treeModelListeners) {
                tml.treeStructureChanged(e);
            }
        }

//////////////// TreeModel interface implementation ///////////////////////
        /**
         * Adds a listener for the TreeModelEvent posted after the tree changes.
         */
        public void addTreeModelListener(TreeModelListener l) {
            treeModelListeners.addElement(l);
        }

        /**
         * Returns the child of parent at index index in the parent's child array.
         */
        public Object getChild(Object parent, int index) {
            Person p = (Person) parent;
            if (showAncestors) {
                if ((index > 0) && (p.getFather() != null)) {
                    return p.getMother();
                }
                return p.getFather();
            }
            return p.getChildAt(index);
        }

        /**
         * Returns the number of children of parent.
         */
        public int getChildCount(Object parent) {
            Person p = (Person) parent;
            if (showAncestors) {
                int count = 0;
                if (p.getFather() != null) {
                    count++;
                }
                if (p.getMother() != null) {
                    count++;
                }
                return count;
            }
            return p.getChildCount();
        }

        /**
         * Returns the index of child in parent.
         */
        public int getIndexOfChild(Object parent, Object child) {
            Person p = (Person) parent;
            if (showAncestors) {
                int count = 0;
                Person father = p.getFather();
                if (father != null) {
                    count++;
                    if (father == child) {
                        return 0;
                    }
                }
                if (p.getMother() != child) {
                    return count;
                }
                return -1;
            }
            return p.getIndexOfChild((Person) child);
        }

        /**
         * Returns the root of the tree.
         */
        public Object getRoot() {
            return rootPerson;
        }

        /**
         * Returns true if node is a leaf.
         */
        public boolean isLeaf(Object node) {
            Person p = (Person) node;
            if (showAncestors) {
                return ((p.getFather() == null)
                        && (p.getMother() == null));
            }
            return p.getChildCount() == 0;
        }

        /**
         * Removes a listener previously added with addTreeModelListener().
         */
        public void removeTreeModelListener(TreeModelListener l) {
            treeModelListeners.removeElement(l);
        }

        /**
         * Messaged when the user has altered the value for the item identified by
         * path to newValue. Not used by this model.
         */
        public void valueForPathChanged(TreePath path, Object newValue) {
            System.out.println("*** valueForPathChanged : "
                    + path + " --> " + newValue);
        }
    }

    public static class Person {

        Person father;
        Person mother;
        List<Person> children;
        private String name;

        public Person(String name) {
            this.name = name;
            mother = father = null;
            children = new ArrayList<Person>();
        }

        /**
         * Link together all members of a family.
         *
         * @param pa the father
         * @param ma the mother
         * @param kids the children
         */
        public static void linkFamily(Person pa,
                Person ma,
                Person[] kids) {
            for (Person kid : kids) {
                pa.children.add(kid);
                ma.children.add(kid);
                kid.father = pa;
                kid.mother = ma;
            }
        }

/// getter methods ///////////////////////////////////
        public String toString() {
            return name;
        }

        public String getName() {
            return name;
        }

        public Person getFather() {
            return father;
        }

        public Person getMother() {
            return mother;
        }

        public int getChildCount() {
            return children.size();
        }

        public Person getChildAt(int i) {
            return (Person) children.get(i);
        }

        public int getIndexOfChild(Person kid) {
            return children.indexOf(kid);
        }
    }
}

