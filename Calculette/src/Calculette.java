

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculette extends JPanel{
	
	JPanel p;
	JButton ba,bz,be,br,bt,by,bu,bi,baa,bzz,bee,brr,btt,byy,buu,bii,bta,byz,bue,bir;
	JTextField j;
	String s="0.0";
	String t="";
	String a1="";
	String a2="";
	double q;
	boolean nd=true;
	
	public Calculette() {
		p=new JPanel();
		p.setPreferredSize(new Dimension(220,160));
		this.setLayout(new BorderLayout());
		
		j=new JTextField();
		j.setPreferredSize(new Dimension(220,20));
		p.add(j);
		j.setText("0.0");
		
		EcouteurBouton ecouteur = new EcouteurBouton();
		ba=new JButton("7");
		ba.addActionListener(ecouteur);
		ba.setPreferredSize(new Dimension(50,20));
		
		bz=new JButton("8");
        bz.addActionListener(ecouteur);
        bz.setPreferredSize(new Dimension(50,20));

        be=new JButton("9");
        be.addActionListener(ecouteur);
        be.setPreferredSize(new Dimension(50,20));

        br=new JButton("+");
        br.addActionListener(ecouteur);
        br.setPreferredSize(new Dimension(50,20));

        bt=new JButton("4");
        bt.addActionListener(ecouteur);
        bt.setPreferredSize(new Dimension(50,20));

        by=new JButton("5");
        by.addActionListener(ecouteur);
        by.setPreferredSize(new Dimension(50,20));

        bu=new JButton("6");
        bu.addActionListener(ecouteur);
        bu.setPreferredSize(new Dimension(50,20));

        bi=new JButton("-");
        bi.addActionListener(ecouteur);
        bi.setPreferredSize(new Dimension(50,20));
        
        baa=new JButton("1");
		baa.addActionListener(ecouteur);
		baa.setPreferredSize(new Dimension(50,20));
		
		bzz=new JButton("2");
        bzz.addActionListener(ecouteur);
        bzz.setPreferredSize(new Dimension(50,20));

        bee=new JButton("3");
        bee.addActionListener(ecouteur);
        bee.setPreferredSize(new Dimension(50,20));

        brr=new JButton("*");
        brr.addActionListener(ecouteur);
        brr.setPreferredSize(new Dimension(50,20));

        btt=new JButton("0");
        btt.addActionListener(ecouteur);
        btt.setPreferredSize(new Dimension(50,20));

        byy=new JButton("Clr");
        byy.addActionListener(ecouteur);
        byy.setPreferredSize(new Dimension(50,20));

        buu=new JButton("x2");
        buu.addActionListener(ecouteur);
        buu.setPreferredSize(new Dimension(50,20));

        bii=new JButton("/");
        bii.addActionListener(ecouteur);
        bii.setPreferredSize(new Dimension(50,20));
        
        bta=new JButton("");
        bta.addActionListener(ecouteur);
        bta.setPreferredSize(new Dimension(50,20));

        byz=new JButton("");
        byz.addActionListener(ecouteur);
        byz.setPreferredSize(new Dimension(50,20));

        bue=new JButton("sqrt");
        bue.addActionListener(ecouteur);
        bue.setPreferredSize(new Dimension(50,20));

        bir=new JButton("=");
        bir.addActionListener(ecouteur);
        bir.setPreferredSize(new Dimension(50,20));
        
		this.add(p);
		
		p.add(ba);
		p.add(bz);
        p.add(be);
        p.add(br);
        p.add(bt);
        p.add(by);
        p.add(bu);
        p.add(bi);
        p.add(baa);
		p.add(bzz);
        p.add(bee);
        p.add(brr);
        p.add(btt);
        p.add(byy);
        p.add(buu);
        p.add(bii);
        p.add(bta);
        p.add(byz);
        p.add(bue);
        p.add(bir);
	}
	
	private class EcouteurBouton implements ActionListener{
		public void actionPerformed(ActionEvent e){
		Object source = e.getSource();
		
		
		
		
		if(source.equals(ba)) {
			if(s.contentEquals("0.0")){
				s="7";
				a1+=7;
			}else if(nd){
				s+="7";
				a1+=7;
			}else {
				s+=7;
				a2+=7;
			}
			j.setText(s);
		}
		if(source.equals(bz)) {
			if(s.contentEquals("0.0")){
				s="8";
				a1+=8;
			}else if(nd){
				s+="8";
				a1+=8;
			}else {
				s+=8;
				a2+=8;
			}
			j.setText(s);
		}
		if(source.equals(be)) {
			if(s.contentEquals("0.0")){
				s="9";
				a1+=9;
			}else if(nd){
				s+="9";
				a1+=9;
			}else {
				s+=9;
				a2+=9;
			}
			j.setText(s);
		}
		
		if(source.equals(bt)) {
			if(s.contentEquals("0.0")){
				s="4";
				a1+=4;
			}else if(nd){
				s+="4";
				a1+=4;
			}else {
				s+=4;
				a2+=4;
			}
			j.setText(s);
		}
		
		if(source.equals(by)) {
			if(s.contentEquals("0.0")){
				s="5";
				a1+=5;
			}else if(nd){
				s+="5";
				a1+=5;
			}else {
				s+=5;
				a2+=5;
			}
			j.setText(s);
		}
		if(source.equals(bu)) {
			if(s.contentEquals("0.0")){
				s="6";
				a1+=6;
			}else if(nd){
				s+="6";
				a1+=6;
			}else {
				s+=6;
				a2+=6;
			}
			j.setText(s);
		}
		if(source.equals(baa)) {
			if(s.contentEquals("0.0")){
				s="1";
				a1+=1;
			}else if(nd){
				s+="1";
				a1+=1;
			}else {
				s+=1;
				a2+=1;
			}
			j.setText(s);
		}
		if(source.equals(bzz)) {
			if(s.contentEquals("0.0")){
				s="2";
				a1+=2;
			}else if(nd){
				s+="2";
				a1+=2;
			}else {
				s+=2;
				a2+=2;
			}
			j.setText(s);
		}
		if(source.equals(bee)) {
			if(s.contentEquals("0.0")){
				s="3";
				a1+=3;
			}else if(nd){
				s+="3";
				a1+=3;
			}else {
				s+=3;
				a2+=3;
			}
			j.setText(s);
		}
		if(source.equals(btt)) {
			if(s.contentEquals("0.0")){
				s="0";
				a1+=0;
			}else if(nd){
				s+="0";
				a1+=0;
			}else {
				s+=0;
				a2+=0;
			}
			j.setText(s);
		}
		
		
		
		
		
		if(source.equals(br)) {
			if(s.contentEquals("0.0")){
			}if(nd) {
				nd=false;
				s+="+";
				t="+";
			}else{
				calcul("+");
			}
			j.setText(s);
		}
		if(source.equals(byy)) {
			s="0.0";
			a1="";
			a2="";
			t="";
			nd=true;
			j.setText(s);
		}
		if(source.equals(buu)) {
			if(s.contentEquals("0.0")){
			}if(nd) {
				nd=false;
				s+="²";
				t="²";
			}else{
				calcul("²");
			}
			j.setText(s);
		}
		if(source.equals(bii)) {
			if(s.contentEquals("0.0")){
			}if(nd) {
				nd=false;
				s+="/";
				t="/";
			}else{
				calcul("/");
			}
			j.setText(s);
		}
		if(source.equals(bue)) {
			/*if(s.contentEquals("0.0")){
				s="sqrt";
				t="sqrt";
				nd=false;
			}else if(nd) {
				nd=false;
				s="sqrt"+s;
				t="sqrt";
			}else{
				calcul("sqrt");
			}*/
			j.setText("ERREUR");
		}
		if(source.equals(bir)) {
			if(s.contentEquals("0.0")){
			}if(nd) {
				nd=false;
				s+="=";
				t="=";
			}else{
				calcul("=");
			}
			j.setText(s);
		}
		if(source.equals(brr)) {
			if(s.contentEquals("0.0")){
			}if(nd) {
				nd=false;
				s+="*";
				t="*";
			}else{
				calcul("*");
			}
			j.setText(s);
		}
		if(source.equals(bi)) {
			if(s.contentEquals("0.0")){
			}if(nd) {
				nd=false;
				s+="-";
				t="-";
			}else{
				calcul("-");
			}
			j.setText(s);
		}
		
		
		}
		public void calcul(String h) {
			
			if(t.contentEquals("+")) {
				q = Double.parseDouble(a1) + Double.parseDouble(a2);	
			}else if(t.contentEquals("-")) {
				q = Double.parseDouble(a1) - Double.parseDouble(a2);		
			}else if(t.contentEquals("*")) {
				q = Double.parseDouble(a1) * Double.parseDouble(a2);	
			}else if(t.contentEquals("/")) {
				q = Double.parseDouble(a1) / Double.parseDouble(a2);	
			}else if(t.contentEquals("²")) {
				q = Double.parseDouble(a1) * Double.parseDouble(a1);	
			}/*else if(t.contentEquals("sqrt")) {
				q = Math.sqrt(Double.parseDouble(a1));	
			}*/else if(t.contentEquals("=")) {
				q = Double.parseDouble(a1);		
			}
				t=h;
				s=q+"";
				a1=s;
				s+=h;
				a2="";
		}
	}
	
	public static void main(String[] args) {
		JFrame fenetre = new JFrame ("Art");
		fenetre.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		fenetre.setVisible (true );
		Calculette dessin = new Calculette();
		dessin.setPreferredSize(new Dimension(220,160));
		fenetre.setContentPane(dessin);
		fenetre.pack();
	}
}
