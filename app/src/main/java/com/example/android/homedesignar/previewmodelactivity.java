package com.example.android.homedesignar;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.ar.core.exceptions.CameraNotAvailableException;
import com.google.ar.sceneform.ArSceneView;
import com.google.ar.sceneform.Camera;
import com.google.ar.sceneform.HitTestResult;
import com.google.ar.sceneform.Node;
import com.google.ar.sceneform.Scene;
import com.google.ar.sceneform.SceneView;
import com.google.ar.sceneform.math.Quaternion;
import com.google.ar.sceneform.math.Vector3;
import com.google.ar.sceneform.rendering.MaterialFactory;
import com.google.ar.sceneform.rendering.ModelRenderable;
import com.google.ar.sceneform.rendering.ShapeFactory;
import com.google.ar.sceneform.rendering.ViewRenderable;
import com.google.ar.sceneform.ux.FootprintSelectionVisualizer;
import com.google.ar.sceneform.ux.TransformableNode;
import com.google.ar.sceneform.ux.TransformationSystem;

public class previewmodelactivity extends AppCompatActivity {
    private SceneView sceneView;
    private Scene scene;
    ARHomeDesignActivity arHomeDesignActivity;
    private ModelRenderable Bed1renderable, Bed2renderable, Bed3renderable, Bed4renderable,

    Cupb1renderable, Cupb2renderable, Cupb3renderable, Cupb4renderable, Cupb5renderable, Cupb6renderable, Cupb7renderable, Cupb8renderable,

    DiningSet0renderable, DiningSet1renderable, DiningSet2renderable, DiningSet3renderable, DiningSet4renderable, DiningSet6renderable, DiningSet7renderable, DiningSet8renderable,

    DiningTable1renderable, DiningTable2renderable, DiningTable3renderable, DiningTable4renderable, DiningTable5renderable,

    Armchair1renderable, Armchair2renderable, Chair1renderable, Chair3renderable, Chair4renderable, Chair5renderable,

    bedsidetablerenderable, desk1renderable, desk2renderable, desk3renderable, fan1renderable, fan2renderable, kitchen1renderable, kitchen2renderable, pianorenderable, stoverenderable, tvrenderable, washingmachinerenderable,

    sofa1renderable, sofa2renderable, sofa3renderable, sofa4renderable, sofa6renderable, sofa7renderable, sofa8renderable, sofa9renderable, sofa10renderable, sofa11renderable;

    int selected;

    TransformationSystem transformationSystem;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.previewmodel);
        Intent intent= getIntent();
        selected= intent.getIntExtra("selected",1);
        sceneView =findViewById(R.id.scene_view);
        scene= sceneView.getScene();
        transformationSystem=new TransformationSystem(getResources().getDisplayMetrics(),new FootprintSelectionVisualizer());
        sceneView.getRenderer().setClearColor(new com.google.ar.sceneform.rendering.Color(Color.LTGRAY));
        sceneView.getScene().addOnPeekTouchListener((hitTestResult, motionEvent) -> {
            transformationSystem.onTouch(hitTestResult,motionEvent);

        });
        attachmodel();

        TransformableNode node = new TransformableNode(transformationSystem);
        node.getRotationController().setEnabled(true);
        node.getScaleController().setEnabled(true);
        node.getTranslationController().setEnabled(false);
        previewmodelfunction(node);


    }


    private void previewmodelfunction(TransformableNode node) {

        if(selected==1){

        node.setRenderable(Bed1renderable);
        node.setParent(scene);
        node.setLocalPosition(new Vector3(0f,-3f,-10f));
        node.select();
        scene.addChild(node);
        }
        if(selected==2){

            node.setRenderable(Bed2renderable);
            node.setParent(scene);
            node.setLocalPosition(new Vector3(0f,-3f,-10f));
            node.select();
            scene.addChild(node);
        }
        if(selected==3){

            node.setRenderable(Bed3renderable);
            node.setParent(scene);
            node.setLocalPosition(new Vector3(0f,-3f,-10f));
            transformationSystem.selectNode(node);
            scene.addChild(node);
        }
        if(selected==4){

            node.setRenderable(Bed4renderable);
            node.setParent(scene);
            node.setLocalPosition(new Vector3(0f,-3f,-10f));
            transformationSystem.selectNode(node);
            scene.addChild(node);
        }
        if(selected==5){

            node.setRenderable(Cupb1renderable);
            node.setParent(scene);
            node.setLocalPosition(new Vector3(0f,-3f,-10f));
            transformationSystem.selectNode(node);
            scene.addChild(node);
        }
        if(selected==6){

            node.setRenderable(Cupb2renderable);
            node.setParent(scene);
            node.setLocalPosition(new Vector3(0f,-3f,-10f));
            transformationSystem.selectNode(node);
            scene.addChild(node);
        }
        if(selected==7){

            node.setRenderable(Cupb3renderable);
            node.setParent(scene);
            node.setLocalPosition(new Vector3(0f,-3f,-10f));
            transformationSystem.selectNode(node);
            scene.addChild(node);
        }
        if(selected==8){
            node.setRenderable(Cupb4renderable);
            node.setParent(scene);
            node.setLocalPosition(new Vector3(0f,-3f,-10f));
            transformationSystem.selectNode(node);
            scene.addChild(node);
        }
        if(selected==9){
            node.setRenderable(Cupb5renderable);
            node.setParent(scene);
            node.setLocalPosition(new Vector3(0f,-3f,-10f));
            transformationSystem.selectNode(node);
            scene.addChild(node);
        }
        if(selected==10){
            node.setRenderable(Cupb6renderable);
            node.setParent(scene);
            node.setLocalPosition(new Vector3(0f,-3f,-10f));
            transformationSystem.selectNode(node);
            scene.addChild(node);
        }
        if(selected==11){
            node.setRenderable(Cupb7renderable);
            node.setParent(scene);
            node.setLocalPosition(new Vector3(0f,-3f,-10f));
            transformationSystem.selectNode(node);
            scene.addChild(node);
        }
        if(selected==12) {
            node.setRenderable(Cupb8renderable);
            node.setParent(scene);
            node.setLocalPosition(new Vector3(0f, -3f, -10f));
            transformationSystem.selectNode(node);
            scene.addChild(node);
        }
        if(selected==13){
            node.setRenderable(DiningSet0renderable);
            node.setParent(scene);
            node.setLocalPosition(new Vector3(0f,-3f,-10f));
            transformationSystem.selectNode(node);
            scene.addChild(node);
        }
        if(selected==14){
            node.setRenderable(DiningSet1renderable);
            node.setParent(scene);
            node.setLocalPosition(new Vector3(0f,-3f,-10f));
            transformationSystem.selectNode(node);
            scene.addChild(node);
        }
        if(selected==15){
            node.setRenderable(DiningSet2renderable);
            node.setParent(scene);
            node.setLocalPosition(new Vector3(0f,-3f,-10f));
            transformationSystem.selectNode(node);
            scene.addChild(node);
        }
        if(selected==16){
            node.setRenderable(DiningSet3renderable);
            node.setParent(scene);
            node.setLocalPosition(new Vector3(0f,-3f,-10f));
            transformationSystem.selectNode(node);
            scene.addChild(node);
        }
        if(selected==17){
            node.setRenderable(DiningSet4renderable);
            node.setParent(scene);
            node.setLocalPosition(new Vector3(0f,-3f,-10f));
            transformationSystem.selectNode(node);
            scene.addChild(node);
        }
        if(selected==18){
            node.setRenderable(DiningSet6renderable);
            node.setParent(scene);
            node.setLocalPosition(new Vector3(0f,-3f,-10f));
            transformationSystem.selectNode(node);
            scene.addChild(node);
        }
        if(selected==19){
            node.setRenderable(DiningSet7renderable);
            node.setParent(scene);
            node.setLocalPosition(new Vector3(0f,-3f,-10f));
            transformationSystem.selectNode(node);
            scene.addChild(node);
        }
        if(selected==20){
            node.setRenderable(DiningSet8renderable);
            node.setParent(scene);
            node.setLocalPosition(new Vector3(0f,-3f,-10f));
            transformationSystem.selectNode(node);
            scene.addChild(node);
        }
        if(selected==21){
            node.setRenderable(DiningTable1renderable);
            node.setParent(scene);
            node.setLocalPosition(new Vector3(0f,-3f,-10f));
            transformationSystem.selectNode(node);
            scene.addChild(node);
        }
        if(selected==22){
            node.setRenderable(DiningTable2renderable);
            node.setParent(scene);
            node.setLocalPosition(new Vector3(0f,-3f,-10f));
            transformationSystem.selectNode(node);
            scene.addChild(node);
        }
        if(selected==23){
            node.setRenderable(DiningTable3renderable);
            node.setParent(scene);
            node.setLocalPosition(new Vector3(0f,-3f,-10f));
            transformationSystem.selectNode(node);
            scene.addChild(node);
        }
        if(selected==24){
            node.setRenderable(DiningTable4renderable);
            node.setParent(scene);
            node.setLocalPosition(new Vector3(0f,-3f,-10f));
            transformationSystem.selectNode(node);
            scene.addChild(node);
        }
        if(selected==25){
            node.setRenderable(DiningTable5renderable);
            node.setParent(scene);
            node.setLocalPosition(new Vector3(0f,-3f,-10f));
            transformationSystem.selectNode(node);
            scene.addChild(node);
        }
        if(selected==26){
            node.setRenderable(Armchair1renderable);
            node.setParent(scene);
            node.setLocalPosition(new Vector3(0f,-3f,-10f));
            transformationSystem.selectNode(node);
            scene.addChild(node);
        }
        if(selected==27){
            node.setRenderable(Armchair2renderable);
            node.setParent(scene);
            node.setLocalPosition(new Vector3(0f,-3f,-10f));
            transformationSystem.selectNode(node);
            scene.addChild(node);
        }
        if(selected==28){
            node.setRenderable(Chair1renderable);
            node.setParent(scene);
            node.setLocalPosition(new Vector3(0f,-3f,-10f));
            transformationSystem.selectNode(node);
            scene.addChild(node);
        }
        if(selected==29){
            node.setRenderable(Chair3renderable);
            node.setParent(scene);
            node.setLocalPosition(new Vector3(0f,-3f,-10f));
            transformationSystem.selectNode(node);
            scene.addChild(node);
        }
        if(selected==30){
            node.setRenderable(Chair4renderable);
            node.setParent(scene);
            node.setLocalPosition(new Vector3(0f,-3f,-10f));
            transformationSystem.selectNode(node);
            scene.addChild(node);
        }
        if(selected==31){
            node.setRenderable(Chair5renderable);
            node.setParent(scene);
            node.setLocalPosition(new Vector3(0f,-3f,-10f));
            transformationSystem.selectNode(node);
            scene.addChild(node);
        }
        if(selected==32){
            node.setRenderable(bedsidetablerenderable);
            node.setParent(scene);
            node.setLocalPosition(new Vector3(0f,-3f,-10f));
            transformationSystem.selectNode(node);
            scene.addChild(node);
        }
        if(selected==33){
            node.setRenderable(desk1renderable);
            node.setParent(scene);
            node.setLocalPosition(new Vector3(0f,-3f,-10f));
            transformationSystem.selectNode(node);
            scene.addChild(node);
        }
        if(selected==34){
            node.setRenderable(desk2renderable);
            node.setParent(scene);
            node.setLocalPosition(new Vector3(0f,-3f,-10f));
            transformationSystem.selectNode(node);
            scene.addChild(node);
        }
        if(selected==35){
            node.setRenderable(desk3renderable);
            node.setParent(scene);
            node.setLocalPosition(new Vector3(0f,-3f,-10f));
            transformationSystem.selectNode(node);
            scene.addChild(node);
        }
        if(selected==36){
            node.setRenderable(fan1renderable);
            node.setParent(scene);
            node.setLocalPosition(new Vector3(0f,-3f,-10f));
            transformationSystem.selectNode(node);
            scene.addChild(node);
        }
        if(selected==37){
            node.setRenderable(fan2renderable);
            node.setParent(scene);
            node.setLocalPosition(new Vector3(0f,-3f,-10f));
            transformationSystem.selectNode(node);
            scene.addChild(node);
        }
        if(selected==38){
            node.setRenderable(kitchen1renderable);
            node.setParent(scene);
            node.setLocalPosition(new Vector3(0f,-3f,-10f));
            transformationSystem.selectNode(node);
            scene.addChild(node);
        }
        if(selected==39){
            node.setRenderable(kitchen2renderable);
            node.setParent(scene);
            node.setLocalPosition(new Vector3(0f,-3f,-10f));
            transformationSystem.selectNode(node);
            scene.addChild(node);
        }
        if(selected==40){
            node.setRenderable(pianorenderable);
            node.setParent(scene);
            node.setLocalPosition(new Vector3(0f,-3f,-10f));
            transformationSystem.selectNode(node);
            scene.addChild(node);
        }
        if(selected==41){
            node.setRenderable(stoverenderable);
            node.setParent(scene);
            node.setLocalPosition(new Vector3(0f,-3f,-10f));
            transformationSystem.selectNode(node);
            scene.addChild(node);
        }
        if(selected==42){
            node.setRenderable(tvrenderable);
            node.setParent(scene);
            node.setLocalPosition(new Vector3(0f,-3f,-10f));
            transformationSystem.selectNode(node);
            scene.addChild(node);
        }
        if(selected==43){
            node.setRenderable(washingmachinerenderable);
            node.setParent(scene);
            node.setLocalPosition(new Vector3(0f,-3f,-10f));
            transformationSystem.selectNode(node);
            scene.addChild(node);
        }
        if(selected==44){
            node.setRenderable(sofa1renderable);
            node.setParent(scene);
            node.setLocalPosition(new Vector3(0f,-3f,-10f));
            transformationSystem.selectNode(node);
            scene.addChild(node);
        }
        if(selected==45){
            node.setRenderable(sofa2renderable);
            node.setParent(scene);
            node.setLocalPosition(new Vector3(0f,-3f,-10f));
            transformationSystem.selectNode(node);
            scene.addChild(node);
        }
        if(selected==46){
            node.setRenderable(sofa3renderable);
            node.setParent(scene);
            node.setLocalPosition(new Vector3(0f,-3f,-10f));
            transformationSystem.selectNode(node);
            scene.addChild(node);
        }
        if(selected==47){
            node.setRenderable(sofa4renderable);
            node.setParent(scene);
            node.setLocalPosition(new Vector3(0f,-3f,-10f));
            transformationSystem.selectNode(node);
            scene.addChild(node);
        }
        if(selected==48){
            node.setRenderable(sofa6renderable);
            node.setParent(scene);
            node.setLocalPosition(new Vector3(0f,-3f,-10f));
            transformationSystem.selectNode(node);
            scene.addChild(node);
        }
        if(selected==49){
            node.setRenderable(sofa7renderable);
            node.setParent(scene);
            node.setLocalPosition(new Vector3(0f,-3f,-10f));
            transformationSystem.selectNode(node);
            scene.addChild(node);
        }
        if(selected==50){
            node.setRenderable(sofa8renderable);
            node.setParent(scene);
            node.setLocalPosition(new Vector3(0f,-3f,-10f));
            transformationSystem.selectNode(node);
            scene.addChild(node);
        }
        if(selected==51){
            node.setRenderable(sofa9renderable);
            node.setParent(scene);
            node.setLocalPosition(new Vector3(0f,-3f,-10f));
            transformationSystem.selectNode(node);
            scene.addChild(node);
        }
        if(selected==52){
            node.setRenderable(sofa10renderable);
            node.setParent(scene);
            node.setLocalPosition(new Vector3(0f,-3f,-10f));
            transformationSystem.selectNode(node);
            scene.addChild(node);
        }
        if(selected==53){
            node.setRenderable(sofa11renderable);
            node.setParent(scene);
            node.setLocalPosition(new Vector3(0f,-3f,-10f));
            transformationSystem.selectNode(node);
            scene.addChild(node);
        }





    }

    private void attachmodel() {



        ModelRenderable.builder()
                .setSource(this, Uri.parse("Bed1.sfb.sfb"))
                .build().thenAccept(renderable -> Bed1renderable =renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(this,"Unable to load bed",Toast.LENGTH_SHORT).show();
                    return null;
                });

        ModelRenderable.builder()
                .setSource(this, Uri.parse("Bed2.sfb.sfb"))
                .build().thenAccept(renderable -> Bed2renderable =renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(this,"Unable to load bed",Toast.LENGTH_SHORT).show();
                    return null;
                });
        ModelRenderable.builder()
                .setSource(this, Uri.parse("Bed3.sfb.sfb"))
                .build().thenAccept(renderable -> Bed3renderable =renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(this,"Unable to load bed",Toast.LENGTH_SHORT).show();
                    return null;
                });
        ModelRenderable.builder()
                .setSource(this, Uri.parse("Cabana.sfb.sfb"))
                .build().thenAccept(renderable -> Bed4renderable =renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(this,"Unable to load bed",Toast.LENGTH_SHORT).show();
                    return null;
                });
        ModelRenderable.builder()
                .setSource(this, Uri.parse("Cupb1.sfb.sfb"))
                .build().thenAccept(renderable -> Cupb1renderable =renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(this,"Unable to load cupboard",Toast.LENGTH_SHORT).show();
                    return null;
                });
        ModelRenderable.builder()
                .setSource(this, Uri.parse("Cupb2.sfb.sfb"))
                .build().thenAccept(renderable -> Cupb2renderable =renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(this,"Unable to load cupboard",Toast.LENGTH_SHORT).show();
                    return null;
                });
        ModelRenderable.builder()
                .setSource(this, Uri.parse("Cupb3.sfb.sfb"))
                .build().thenAccept(renderable -> Cupb3renderable =renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(this,"Unable to load cupboard",Toast.LENGTH_SHORT).show();
                    return null;
                });
        ModelRenderable.builder()
                .setSource(this, Uri.parse("Cupb4.sfb.sfb"))
                .build().thenAccept(renderable -> Cupb4renderable =renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(this,"Unable to load cupboard",Toast.LENGTH_SHORT).show();
                    return null;
                });
        ModelRenderable.builder()
                .setSource(this, Uri.parse("Cupb5.sfb.sfb"))
                .build().thenAccept(renderable -> Cupb5renderable =renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(this,"Unable to load cupboard",Toast.LENGTH_SHORT).show();
                    return null;
                });
        ModelRenderable.builder()
                .setSource(this, Uri.parse("Cupd6.sfb.sfb"))
                .build().thenAccept(renderable -> Cupb6renderable =renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(this,"Unable to load cupboard",Toast.LENGTH_SHORT).show();
                    return null;
                });
        ModelRenderable.builder()
                .setSource(this, Uri.parse("Cupb7.sfb.sfb"))
                .build().thenAccept(renderable -> Cupb7renderable =renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(this,"Unable to load cupboard",Toast.LENGTH_SHORT).show();
                    return null;
                });
        ModelRenderable.builder()
                .setSource(this, Uri.parse("Cupb8.sfb.sfb"))
                .build().thenAccept(renderable -> Cupb8renderable =renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(this,"Unable to load cupboard",Toast.LENGTH_SHORT).show();
                    return null;
                });
        ModelRenderable.builder()
                .setSource(this, Uri.parse("DiningSet0.sfb.sfb"))
                .build().thenAccept(renderable -> DiningSet0renderable =renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(this,"Unable to load Dining Set",Toast.LENGTH_SHORT).show();
                    return null;
                });
        ModelRenderable.builder()
                .setSource(this, Uri.parse("DiningSet1.sfb.sfb"))
                .build().thenAccept(renderable -> DiningSet1renderable =renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(this,"Unable to load Dining Set",Toast.LENGTH_SHORT).show();
                    return null;
                });
        ModelRenderable.builder()
                .setSource(this, Uri.parse("DiningSet2.sfb.sfb"))
                .build().thenAccept(renderable -> DiningSet2renderable =renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(this,"Unable to load Dining Set",Toast.LENGTH_SHORT).show();
                    return null;
                });
        ModelRenderable.builder()
                .setSource(this, Uri.parse("DiningSet3.sfb.sfb"))
                .build().thenAccept(renderable -> DiningSet3renderable =renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(this,"Unable to load Dining Set",Toast.LENGTH_SHORT).show();
                    return null;
                });
        ModelRenderable.builder()
                .setSource(this, Uri.parse("DiningSet4.sfb.sfb"))
                .build().thenAccept(renderable -> DiningSet4renderable =renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(this,"Unable to load Dining Set",Toast.LENGTH_SHORT).show();
                    return null;
                });
        ModelRenderable.builder()
                .setSource(this, Uri.parse("DiningSet6.sfb.sfb"))
                .build().thenAccept(renderable -> DiningSet6renderable =renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(this,"Unable to load Dining Set",Toast.LENGTH_SHORT).show();
                    return null;
                });
        ModelRenderable.builder()
                .setSource(this, Uri.parse("DiningSet7.sfb.sfb"))
                .build().thenAccept(renderable -> DiningSet7renderable =renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(this,"Unable to load Dining Set",Toast.LENGTH_SHORT).show();
                    return null;
                });  ModelRenderable.builder()
                .setSource(this, Uri.parse("DiningSet8.sfb.sfb"))
                .build().thenAccept(renderable -> DiningSet8renderable =renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(this,"Unable to load Dining Set",Toast.LENGTH_SHORT).show();
                    return null;
                });  ModelRenderable.builder()
                .setSource(this, Uri.parse("DiningTable1.sfb.sfb"))
                .build().thenAccept(renderable -> DiningTable1renderable =renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(this,"Unable to load Dining Table",Toast.LENGTH_SHORT).show();
                    return null;
                });
        ModelRenderable.builder()
                .setSource(this, Uri.parse("DiningTable2.sfb.sfb"))
                .build().thenAccept(renderable -> DiningTable2renderable =renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(this,"Unable to load Dining Table",Toast.LENGTH_SHORT).show();
                    return null;
                });
        ModelRenderable.builder()
                .setSource(this, Uri.parse("DiningTable3.sfb.sfb"))
                .build().thenAccept(renderable -> DiningTable3renderable =renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(this,"Unable to load Dining Table",Toast.LENGTH_SHORT).show();
                    return null;
                });
        ModelRenderable.builder()
                .setSource(this, Uri.parse("DiningTable4.sfb.sfb"))
                .build().thenAccept(renderable -> DiningTable4renderable =renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(this,"Unable to load Dining Table",Toast.LENGTH_SHORT).show();
                    return null;
                });
        ModelRenderable.builder()
                .setSource(this, Uri.parse("DiningTable5.sfb.sfb"))
                .build().thenAccept(renderable -> DiningTable5renderable =renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(this,"Unable to load Dining Table",Toast.LENGTH_SHORT).show();
                    return null;
                });
        ModelRenderable.builder()
                .setSource(this, Uri.parse("Armchair1.sfb.sfb"))
                .build().thenAccept(renderable -> Armchair1renderable =renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(this,"Unable to load Armchair",Toast.LENGTH_SHORT).show();
                    return null;
                });
        ModelRenderable.builder()
                .setSource(this, Uri.parse("Armchair2.sfb.sfb"))
                .build().thenAccept(renderable -> Armchair2renderable =renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(this,"Unable to load Armchair",Toast.LENGTH_SHORT).show();
                    return null;
                });
        ModelRenderable.builder()
                .setSource(this, Uri.parse("Chair1.sfb.sfb"))
                .build().thenAccept(renderable -> Chair1renderable =renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(this,"Unable to load chair",Toast.LENGTH_SHORT).show();
                    return null;
                });
        ModelRenderable.builder()
                .setSource(this, Uri.parse("Chair3.sfb.sfb"))
                .build().thenAccept(renderable -> Chair3renderable =renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(this,"Unable to load chair",Toast.LENGTH_SHORT).show();
                    return null;
                });
        ModelRenderable.builder()
                .setSource(this, Uri.parse("Chair4.sfb.sfb"))
                .build().thenAccept(renderable -> Chair4renderable =renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(this,"Unable to load chair",Toast.LENGTH_SHORT).show();
                    return null;
                });
        ModelRenderable.builder()
                .setSource(this, Uri.parse("Chair5.sfb.sfb"))
                .build().thenAccept(renderable -> Chair5renderable =renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(this,"Unable to load chair",Toast.LENGTH_SHORT).show();
                    return null;
                });
        ModelRenderable.builder()
                .setSource(this, Uri.parse("BedsideTable.sfb.sfb"))
                .build().thenAccept(renderable -> bedsidetablerenderable =renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(this,"Unable to load Bed side Table",Toast.LENGTH_SHORT).show();
                    return null;
                });
        ModelRenderable.builder()
                .setSource(this, Uri.parse("Desk1.sfb.sfb"))
                .build().thenAccept(renderable -> desk1renderable =renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(this,"Unable to load desk",Toast.LENGTH_SHORT).show();
                    return null;
                });
        ModelRenderable.builder()
                .setSource(this, Uri.parse("Desk2.sfb.sfb"))
                .build().thenAccept(renderable -> desk2renderable =renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(this,"Unable to load desk",Toast.LENGTH_SHORT).show();
                    return null;
                });
        ModelRenderable.builder()
                .setSource(this, Uri.parse("Desk3.sfb.sfb"))
                .build().thenAccept(renderable -> desk3renderable =renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(this,"Unable to load desk",Toast.LENGTH_SHORT).show();
                    return null;
                });
        ModelRenderable.builder()
                .setSource(this, Uri.parse("Fan1.sfb.sfb"))
                .build().thenAccept(renderable -> fan1renderable =renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(this,"Unable to load Fan",Toast.LENGTH_SHORT).show();
                    return null;
                });
        ModelRenderable.builder()
                .setSource(this, Uri.parse("Fan2.sfb.sfb"))
                .build().thenAccept(renderable -> fan2renderable =renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(this,"Unable to load Fan",Toast.LENGTH_SHORT).show();
                    return null;
                });
        ModelRenderable.builder()
                .setSource(this, Uri.parse("Kitchen1.sfb.sfb"))
                .build().thenAccept(renderable -> kitchen1renderable =renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(this,"Unable to load Kitchen",Toast.LENGTH_SHORT).show();
                    return null;
                });
        ModelRenderable.builder()
                .setSource(this, Uri.parse("Kitchen1.sfb.sfb"))
                .build().thenAccept(renderable -> kitchen2renderable =renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(this,"Unable to load Kitchen",Toast.LENGTH_SHORT).show();
                    return null;
                });
        ModelRenderable.builder()
                .setSource(this, Uri.parse("Piano.sfb.sfb"))
                .build().thenAccept(renderable -> pianorenderable =renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(this,"Unable to load piano",Toast.LENGTH_SHORT).show();
                    return null;
                });
        ModelRenderable.builder()
                .setSource(this, Uri.parse("Stove.sfb.sfb"))
                .build().thenAccept(renderable -> stoverenderable =renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(this,"Unable to load stove",Toast.LENGTH_SHORT).show();
                    return null;
                });
        ModelRenderable.builder()
                .setSource(this, Uri.parse("TV.sfb.sfb"))
                .build().thenAccept(renderable -> tvrenderable =renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(this,"Unable to load TV",Toast.LENGTH_SHORT).show();
                    return null;
                });
        ModelRenderable.builder()
                .setSource(this, Uri.parse("Washing Machine.sfb.sfb"))
                .build().thenAccept(renderable -> washingmachinerenderable =renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(this,"Unable to load Washing machine",Toast.LENGTH_SHORT).show();
                    return null;
                });
        ModelRenderable.builder()
                .setSource(this, Uri.parse("Sofa1.sfb.sfb"))
                .build().thenAccept(renderable -> sofa1renderable =renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(this,"Unable to load Sofa",Toast.LENGTH_SHORT).show();
                    return null;
                });
        ModelRenderable.builder()
                .setSource(this, Uri.parse("Sofa2.sfb.sfb"))
                .build().thenAccept(renderable -> sofa2renderable =renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(this,"Unable to load Sofa",Toast.LENGTH_SHORT).show();
                    return null;
                });
        ModelRenderable.builder()
                .setSource(this, Uri.parse("Sofa3.sfb.sfb"))
                .build().thenAccept(renderable -> sofa3renderable =renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(this,"Unable to load Sofa",Toast.LENGTH_SHORT).show();
                    return null;
                });
        ModelRenderable.builder()
                .setSource(this, Uri.parse("Sofa4.sfb.sfb"))
                .build().thenAccept(renderable -> sofa4renderable =renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(this,"Unable to load Sofa",Toast.LENGTH_SHORT).show();
                    return null;
                });
        ModelRenderable.builder()
                .setSource(this, Uri.parse("Sofa6.sfb.sfb"))
                .build().thenAccept(renderable -> sofa6renderable =renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(this,"Unable to load Sofa",Toast.LENGTH_SHORT).show();
                    return null;
                });
        ModelRenderable.builder()
                .setSource(this, Uri.parse("Sofa7.sfb.sfb"))
                .build().thenAccept(renderable -> sofa7renderable =renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(this,"Unable to load Sofa",Toast.LENGTH_SHORT).show();
                    return null;
                });
        ModelRenderable.builder()
                .setSource(this, Uri.parse("Sofa8.sfb.sfb"))
                .build().thenAccept(renderable -> sofa8renderable =renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(this,"Unable to load Sofa",Toast.LENGTH_SHORT).show();
                    return null;
                });
        ModelRenderable.builder()
                .setSource(this, Uri.parse("Sofa9.sfb.sfb"))
                .build().thenAccept(renderable -> sofa9renderable =renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(this,"Unable to load Sofa",Toast.LENGTH_SHORT).show();
                    return null;
                });
        ModelRenderable.builder()
                .setSource(this, Uri.parse("Sofa10.sfb.sfb"))
                .build().thenAccept(renderable -> sofa10renderable =renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(this,"Unable to load Sofa",Toast.LENGTH_SHORT).show();
                    return null;
                });
        ModelRenderable.builder()
                .setSource(this, Uri.parse("Sofa11.sfb.sfb"))
                .build().thenAccept(renderable -> sofa11renderable =renderable)
                .exceptionally(throwable -> {
                    Toast.makeText(this,"Unable to load Sofa",Toast.LENGTH_SHORT).show();
                    return null;
                });
    }



    @Override
    protected void onResume() {
        super.onResume();
//        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
//                != PackageManager.PERMISSION_GRANTED)
//            ActivityCompat.requestPermissions(this,
//                    new String[]{ Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        try{
            sceneView.resume();
        }
        catch(CameraNotAvailableException e){}
    }

    @Override
    protected void onPause(){
        super.onPause();
        sceneView.pause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        sceneView.destroy();
    }
}
