package com.example.android.homedesignar;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.ar.core.Anchor;
import com.google.ar.core.HitResult;
import com.google.ar.core.Pose;
import com.google.ar.sceneform.AnchorNode;
import com.google.ar.sceneform.Camera;
import com.google.ar.sceneform.Node;
import com.google.ar.sceneform.Sun;
import com.google.ar.sceneform.math.Quaternion;
import com.google.ar.sceneform.math.Vector3;
import com.google.ar.sceneform.rendering.MaterialFactory;
import com.google.ar.sceneform.rendering.ModelRenderable;
import com.google.ar.sceneform.rendering.PlaneRenderer;
import com.google.ar.sceneform.rendering.ShapeFactory;
import com.google.ar.sceneform.rendering.ViewRenderable;
import com.google.ar.sceneform.ux.TransformableNode;
import com.sothree.slidinguppanel.SlidingUpPanelLayout;

import java.util.ArrayList;
import java.util.List;

public class ARHomeDesignActivity extends AppCompatActivity implements View.OnClickListener, View.OnLongClickListener {

    private CustomARFrag arFragment;


    private VideoRecorder videoRecorder;
    private ModelRenderable Bed1renderable, Bed2renderable, Bed3renderable, Bed4renderable,

                            Cupb1renderable, Cupb2renderable, Cupb3renderable, Cupb4renderable, Cupb5renderable, Cupb6renderable, Cupb7renderable, Cupb8renderable,

                            DiningSet0renderable, DiningSet1renderable, DiningSet2renderable, DiningSet3renderable, DiningSet4renderable, DiningSet6renderable, DiningSet7renderable, DiningSet8renderable,

                            DiningTable1renderable, DiningTable2renderable, DiningTable3renderable, DiningTable4renderable, DiningTable5renderable,

                            Armchair1renderable, Armchair2renderable, Chair1renderable, Chair3renderable, Chair4renderable, Chair5renderable,

                            bedsidetablerenderable, desk1renderable, desk2renderable, desk3renderable, fan1renderable, fan2renderable, kitchen1renderable, kitchen2renderable, pianorenderable, stoverenderable, tvrenderable, washingmachinerenderable,

                            sofa1renderable, sofa2renderable, sofa3renderable, sofa4renderable, sofa6renderable, sofa7renderable, sofa8renderable, sofa9renderable, sofa10renderable, sofa11renderable,

                            redsphererenderable,linerenderable;
    ViewRenderable distancerenderable;
    Button clearbutton,hostbutton,resolveButton;



    ImageView Bed1, Bed2, Bed3, Bed4,

            Cupb1, Cupb2, Cupb3, Cupb4, Cupb5, Cupb6, Cupb7, Cupb8,

            DiningSet0, DiningSet1, DiningSet2, DiningSet3, DiningSet4, DiningSet6, DiningSet7, DiningSet8,

            DiningTable1, DiningTable2, DiningTable3, DiningTable4, DiningTable5,

            Armchair1, Armchair2, Chair1, Chair3, Chair4, Chair5,

            bedsidetable, desk1, desk2, desk3, fan1, fan2, kitchen1, kitchen2, piano, stove, tv, washingmachine,

            sofa1, sofa2, sofa3, sofa4, sofa6, sofa7, sofa8, sofa9, sofa10, sofa11;

    TextView distbetweenpts;

    View[] bed;
    View[] Cupb;
    View[] DiningSets;
    View[] DiningTables;
    View[] DiningChair;
    View[] Miscellanous;
    View[] Sofa;

    int selected=1;

    Pose startpose,endpose;
    int hit=0;
    Pose[] posearray= new Pose[100];
//    List<AnchorNode> viewanchorList=new ArrayList<>();

    AnchorNode[] viewanchorlist =new AnchorNode[300];
    int k=0;

    private enum AnchorState{
        NONE,
        HOSTING,
        HOSTED,
        RESOLVING,
        RESOLVED
    }

    private FireBaseUpdate fireBaseUpdate;


    private AnchorState anchorState= AnchorState.NONE;
    private Anchor cloudAnchor;
    HitResult hitResultvariable;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.arhomedesign);

        SlidingUpPanelLayout layout =findViewById(R.id.slidingup);
        arFragment= (CustomARFrag) getSupportFragmentManager().findFragmentById(R.id.arfragment);

//        Session session =  new Session(arFragment.getArSceneView().getSession());
//        Config config= new Config(session);
//        config.setFocusMode(Config.FocusMode.AUTO);
//        session.configure(config);
        Switch switchshare = findViewById(R.id.switchshare);


        Bed1= findViewById(R.id.Bed1);
        Bed2= findViewById(R.id.Bed2);
        Bed3= findViewById(R.id.Bed3);
        Bed4= findViewById(R.id.Bed4);

        Cupb1=findViewById(R.id.Cupboard1);
        Cupb2=findViewById(R.id.Cupboard2);
        Cupb3=findViewById(R.id.Cupboard3);
        Cupb4=findViewById(R.id.Cupboard4);
        Cupb5=findViewById(R.id.Cupboard5);
        Cupb6=findViewById(R.id.Cupboard6);
        Cupb7=findViewById(R.id.Cupboard7);
        Cupb8=findViewById(R.id.Cupboard8);

        DiningSet0=findViewById(R.id.DiningSet0);
        DiningSet1=findViewById(R.id.DiningSet1);
        DiningSet2=findViewById(R.id.DiningSet2);
        DiningSet3=findViewById(R.id.DiningSet3);
        DiningSet4=findViewById(R.id.DiningSet4);
        DiningSet6=findViewById(R.id.DiningSet6);
        DiningSet7=findViewById(R.id.DiningSet7);
        DiningSet8=findViewById(R.id.DiningSet8);

        DiningTable1=findViewById(R.id.DiningTable1);
        DiningTable2=findViewById(R.id.DiningTable2);
        DiningTable3=findViewById(R.id.DiningTable3);
        DiningTable4=findViewById(R.id.DiningTable4);
        DiningTable5=findViewById(R.id.DiningTable5);

        Armchair1=findViewById(R.id.Armchair1);
        Armchair2=findViewById(R.id.Armchair2);
        Chair1=findViewById(R.id.Chair1);
        Chair3=findViewById(R.id.Chair3);
        Chair4=findViewById(R.id.Chair4);
        Chair5=findViewById(R.id.Chair5);

        bedsidetable=findViewById(R.id.Bedsidetable);
        desk1=findViewById(R.id.Desk1);
        desk2=findViewById(R.id.Desk2);
        desk3=findViewById(R.id.Desk3);
        fan1=findViewById(R.id.Fan1);
        fan2=findViewById(R.id.Fan2);
        kitchen1=findViewById(R.id.Kitchen1);
        kitchen2=findViewById(R.id.Kitchen2);
        piano=findViewById(R.id.Piano);
        stove=findViewById(R.id.Stove);
        tv=findViewById(R.id.TV);
        washingmachine=findViewById(R.id.WashingMachine);

        sofa1=findViewById(R.id.Sofa1);
        sofa2=findViewById(R.id.Sofa2);
        sofa3=findViewById(R.id.Sofa3);
        sofa4=findViewById(R.id.Sofa4);
        sofa6=findViewById(R.id.Sofa6);
        sofa7=findViewById(R.id.Sofa7);
        sofa8=findViewById(R.id.Sofa8);
        sofa9=findViewById(R.id.Sofa9);
        sofa10=findViewById(R.id.Sofa10);
        sofa11=findViewById(R.id.Sofa11);
        TextView pullup = findViewById(R.id.pullup);
        distbetweenpts = findViewById(R.id.distbetweenpts);
        clearbutton= findViewById(R.id.clearbutton);
        hostbutton= findViewById(R.id.host);
//        Button buttonrecording = findViewById(R.id.recordingbutton);
        resolveButton= findViewById(R.id.resolve);


        switchshare.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    hostbutton.setVisibility(View.VISIBLE);
                    resolveButton.setVisibility(View.VISIBLE);
                }
                else {
                    hostbutton.setVisibility(View.INVISIBLE);
                    resolveButton.setVisibility(View.INVISIBLE);
                }

            }
        });


        layout.addPanelSlideListener(new SlidingUpPanelLayout.PanelSlideListener() {
            @Override
            public void onPanelSlide(View panel, float slideOffset) {


            }

            @Override
            public void onPanelStateChanged(View panel, SlidingUpPanelLayout.PanelState previousState, SlidingUpPanelLayout.PanelState newState) {
                if(layout.getPanelState()==SlidingUpPanelLayout.PanelState.EXPANDED)
                {
                    pullup.setText("TAP HERE TO CLOSE");
                    clearbutton.setVisibility(View.INVISIBLE);
                    hostbutton.setVisibility(View.INVISIBLE);
                    resolveButton.setVisibility(View.INVISIBLE);
                    switchshare.setVisibility(View.INVISIBLE);

                }
                else if(layout.getPanelState()==SlidingUpPanelLayout.PanelState.COLLAPSED){
                    pullup.setText("TAP HERE TO OPEN");
                    clearbutton.setVisibility(View.VISIBLE);
                    switchshare.setVisibility(View.VISIBLE);
                    if(switchshare.isChecked()){
                        hostbutton.setVisibility(View.VISIBLE);
                        resolveButton.setVisibility(View.VISIBLE);
                    }
                    else{
                        hostbutton.setVisibility(View.INVISIBLE);
                        resolveButton.setVisibility(View.INVISIBLE);
                    }



                }
            }
        });

        arrayviewset();
        setonclicklistener();
        setlongonclicklistener();
        attachmodel();

        arFragment.setOnTapArPlaneListener((hitResult, plane, motionEvent) -> {
            hitResultvariable=hitResult;
            Anchor anchor= hitResult.createAnchor();
            AnchorNode anchorNode =new AnchorNode(anchor);
            anchorNode.setParent(arFragment.getArSceneView().getScene());
            createModel(anchorNode,selected,anchor);
        });

        hostbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(hitResultvariable==null){
                    Toast.makeText(ARHomeDesignActivity.this,"Enter a model",Toast.LENGTH_SHORT).show();
                    return;
                }

                Anchor anchor =arFragment.getArSceneView().getSession().hostCloudAnchor(hitResultvariable.createAnchor());
                setCloudAnchor(anchor);
                anchorState=AnchorState.HOSTING;
                Toast.makeText(ARHomeDesignActivity.this,"Hosting Anchor...",Toast.LENGTH_SHORT).show();
                AnchorNode anchorNode =new AnchorNode(cloudAnchor);
                anchorNode.setParent(arFragment.getArSceneView().getScene());
                createModel(anchorNode,selected,cloudAnchor);
            }
        });




        arFragment.getArSceneView().getScene().addOnUpdateListener(frameTime -> {
            arFragment.onUpdate(frameTime);
            //To increase area of surface highlighted
            PlaneRenderer planeRenderer= arFragment.getArSceneView().getPlaneRenderer();
            planeRenderer.getMaterial().thenAccept(material -> {
                material.setFloat(PlaneRenderer.MATERIAL_SPOTLIGHT_RADIUS,5f);
            });


            if(anchorState!=AnchorState.HOSTING&&anchorState!=AnchorState.RESOLVING) {
                return;
            }

            Anchor.CloudAnchorState cloudAnchorState = cloudAnchor.getCloudAnchorState();

            if (anchorState == AnchorState.HOSTING) {

                if (cloudAnchorState.isError()) {
                    Toast.makeText(this, cloudAnchorState.toString(), Toast.LENGTH_SHORT).show();
                    anchorState = AnchorState.NONE;
                }
                else if (cloudAnchorState == Anchor.CloudAnchorState.SUCCESS) {
                    fireBaseUpdate.nextShortCode((shortCode) -> {

                        if (shortCode == null) {
                            Toast.makeText(this, "Could not get code", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        fireBaseUpdate.storeUsingShortCode(shortCode, cloudAnchor.getCloudAnchorId());
                        Toast.makeText(this, "Anchor Hosted Successfully. Anchor ID= " + shortCode, Toast.LENGTH_SHORT).show();
                    });

                    anchorState = AnchorState.HOSTED;
                }
            }

            else if(anchorState==AnchorState.RESOLVING){

                if(cloudAnchorState.isError()){
                    Toast.makeText(this, "Error resolving anchor"+cloudAnchorState, Toast.LENGTH_SHORT).show();
                    anchorState=AnchorState.NONE;
                }

                else if(cloudAnchorState== Anchor.CloudAnchorState.SUCCESS){
                    Toast.makeText(this, "Anchor resolved Successfully", Toast.LENGTH_SHORT).show();
                    anchorState=AnchorState.RESOLVED;
                }
            }
        });

        clearbutton.setOnClickListener(v -> {
            k=0;
            hit=0;
            hitResultvariable=null;
            List<Node> children = new ArrayList<>(arFragment.getArSceneView().getScene().getChildren());
            for (Node node : children) {
                if (node instanceof AnchorNode) {
                    if (((AnchorNode) node).getAnchor() != null) {
                        ((AnchorNode) node).getAnchor().detach();

                    }
                }
                if (!(node instanceof Camera) && !(node instanceof Sun)) {
                    node.setParent(null);
                }
            }


            setCloudAnchor(null);
            for(int i=0; i< viewanchorlist.length;i++) {
                if (viewanchorlist[i] != null) {
                    arFragment.getArSceneView().getScene().removeChild(viewanchorlist[i]);
                    viewanchorlist[i]=null;
                }
            }

        });

//        buttonrecording.setOnClickListener(v ->{
//
//            if(videoRecorder== null){
//                videoRecorder=new VideoRecorder();
//                videoRecorder.setSceneView(arFragment.getArSceneView());
//                int orientation =getResources().getConfiguration().orientation;
//
//                videoRecorder.setVideoQuality(CamcorderProfile.QUALITY_720P,orientation);
//
//            }
//            boolean isrecording =videoRecorder.onToggleRecord();
//            if(isrecording)
//                buttonrecording.setBackgroundResource(R.drawable.recordingstopbutton);
//            else
//                buttonrecording.setBackgroundResource(R.drawable.recordingstartbutton);
//        });
//
//

        //Resolving Anchor

        fireBaseUpdate = new FireBaseUpdate(this);


        resolveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cloudAnchor!=null){
                    Toast.makeText(ARHomeDesignActivity.this,"No Anchor found",Toast.LENGTH_SHORT).show();
                    return;
                }
                ResolveDialogFragment dialogFragment= new ResolveDialogFragment();
                dialogFragment.setOkListener(ARHomeDesignActivity.this::onResolveOKbutton);
                dialogFragment.show(getFragmentManager(),"Resolve");

            }
        });



    }


    private  void onResolveOKbutton(String dialogValue){
    int shortCode=Integer.parseInt(dialogValue);

    fireBaseUpdate.getCloudAnchorID(shortCode,(cloudAnchorId) -> {
        Anchor resolvedAnchor = arFragment.getArSceneView().getSession().resolveCloudAnchor(cloudAnchorId);


        setCloudAnchor(resolvedAnchor);
        AnchorNode anchorNode =new AnchorNode(resolvedAnchor);
        anchorNode.setParent(arFragment.getArSceneView().getScene());
        createModel(anchorNode,selected,resolvedAnchor);
        anchorState=AnchorState.RESOLVING;
        Toast.makeText(this,"Resolving Anchor...",Toast.LENGTH_SHORT).show();
    });
    }


    private void setCloudAnchor(Anchor newAnchor){
        if(cloudAnchor != null){
            cloudAnchor.detach();
        }
        cloudAnchor= newAnchor;
        anchorState=AnchorState.NONE;
    }




    private void previewmodel(){


        Intent intent = new Intent(ARHomeDesignActivity.this,previewmodelactivity.class);
        intent.putExtra("selected",selected);
        startActivity(intent);

    }


    private void attachmodel() {


        ViewRenderable.builder()
                .setView(this,R.layout.distancecard)
                .build()
                .thenAccept(renderable -> distancerenderable= renderable);

        MaterialFactory.makeOpaqueWithColor(this,new com.google.ar.sceneform.rendering.Color(Color.RED))
                .thenAccept(
                        material -> {
                            redsphererenderable= ShapeFactory.makeSphere(0.01f, new Vector3(0.0f, 0.0f,0.0f), material);
                        }
                );


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

    private void finddistance(){
        // Compute the difference vector between the two hit locations.
        float dx = startpose.tx() -endpose.tx() ;
        float dy = startpose.ty() - endpose.ty();
        float dz = startpose.tz() - endpose.tz();

        //midpoint
        float mx = (startpose.tx() + endpose.tx())/2;
        float my= (startpose.ty() + endpose.ty())/2;
        float mz = (startpose.tz() + endpose.tz())/2;

        // Compute the straight-line distance.
        float distanceMeters = (float) Math.sqrt(dx*dx + dy*dy + dz*dz);
        distanceMeters= ((float) (Math.round(distanceMeters*100000)))/100000;
        TextView distancecard= (TextView) distancerenderable.getView();
        distancecard.setText(distanceMeters*100+" cm");

        Vector3 difference =Vector3.subtract( new Vector3(startpose.tx(),startpose.ty(),startpose.tz()),new Vector3(endpose.tx(),endpose.ty(),endpose.tz()));
        Vector3 direction =difference.normalized();
        Quaternion rotationfromAtoB = Quaternion.lookRotation(direction,Vector3.up());

        AnchorNode ANode1 =new AnchorNode();
        ANode1.setParent(arFragment.getArSceneView().getScene());
        ANode1.setWorldPosition(new Vector3(mx, my,mz));
        ANode1.setWorldRotation(rotationfromAtoB);
        ANode1.setRenderable(distancerenderable);
        viewanchorlist[k++]=ANode1;


    }


    private void createModel(AnchorNode anchorNode, int selected, Anchor anchor) {

        if(selected==0){
            anchorNode.setRenderable(redsphererenderable);
            posearray[hit]=anchor.getPose();
            endpose= posearray[hit];
            for(int i=0; i<hit;i++)
            {
                startpose = posearray[i];
                finddistance();
              }
            hit++;
        }

        if(selected==1){
            TransformableNode transformableNode = new TransformableNode(arFragment.getTransformationSystem());
            transformableNode.setParent(anchorNode);
            transformableNode.setRenderable(Bed1renderable);
            transformableNode.select();
        }
        if(selected==2){
            TransformableNode transformableNode = new TransformableNode(arFragment.getTransformationSystem());
            transformableNode.setParent(anchorNode);
            transformableNode.setRenderable(Bed2renderable);
            transformableNode.select();
        }
        if(selected==3){
            TransformableNode transformableNode = new TransformableNode(arFragment.getTransformationSystem());
            transformableNode.setParent(anchorNode);
            transformableNode.setRenderable(Bed3renderable);
            transformableNode.select();
        }
        if(selected==4){
            TransformableNode transformableNode = new TransformableNode(arFragment.getTransformationSystem());
            transformableNode.setParent(anchorNode);
            transformableNode.setRenderable(Bed4renderable);
            transformableNode.select();
        }
        if(selected==5){
            TransformableNode transformableNode = new TransformableNode(arFragment.getTransformationSystem());
            transformableNode.setParent(anchorNode);
            transformableNode.setRenderable(Cupb1renderable);
            transformableNode.select();
        }
        if(selected==6){
            TransformableNode transformableNode = new TransformableNode(arFragment.getTransformationSystem());
            transformableNode.setParent(anchorNode);
            transformableNode.setRenderable(Cupb2renderable);
            transformableNode.select();
        }
        if(selected==7){
            TransformableNode transformableNode = new TransformableNode(arFragment.getTransformationSystem());
            transformableNode.setParent(anchorNode);
            transformableNode.setRenderable(Cupb3renderable);
            transformableNode.select();
        }
        if(selected==8){
            TransformableNode transformableNode = new TransformableNode(arFragment.getTransformationSystem());
            transformableNode.setParent(anchorNode);
            transformableNode.setRenderable(Cupb4renderable);
            transformableNode.select();
        }
        if(selected==9){
            TransformableNode transformableNode = new TransformableNode(arFragment.getTransformationSystem());
            transformableNode.setParent(anchorNode);
            transformableNode.setRenderable(Cupb5renderable);
            transformableNode.select();
        }
        if(selected==10){
            TransformableNode transformableNode = new TransformableNode(arFragment.getTransformationSystem());
            transformableNode.setParent(anchorNode);
            transformableNode.setRenderable(Cupb6renderable);
            transformableNode.select();
        }
        if(selected==11){
            TransformableNode transformableNode = new TransformableNode(arFragment.getTransformationSystem());
            transformableNode.setParent(anchorNode);
            transformableNode.setRenderable(Cupb7renderable);
            transformableNode.select();
        }
        if(selected==12){
            TransformableNode transformableNode = new TransformableNode(arFragment.getTransformationSystem());
            transformableNode.setParent(anchorNode);
            transformableNode.setRenderable(Cupb8renderable);
            transformableNode.select();
        }
        if(selected==13){
            TransformableNode transformableNode = new TransformableNode(arFragment.getTransformationSystem());
            transformableNode.setParent(anchorNode);
            transformableNode.setRenderable(DiningSet0renderable);
            transformableNode.select();
        }
        if(selected==14){
            TransformableNode transformableNode = new TransformableNode(arFragment.getTransformationSystem());
            transformableNode.setParent(anchorNode);
            transformableNode.setRenderable(DiningSet1renderable);
            transformableNode.select();
        }
        if(selected==15){
            TransformableNode transformableNode = new TransformableNode(arFragment.getTransformationSystem());
            transformableNode.setParent(anchorNode);
            transformableNode.setRenderable(DiningSet2renderable);
            transformableNode.select();
        }
        if(selected==16){
            TransformableNode transformableNode = new TransformableNode(arFragment.getTransformationSystem());
            transformableNode.setParent(anchorNode);
            transformableNode.setRenderable(DiningSet3renderable);
            transformableNode.select();
        }
        if(selected==17){
            TransformableNode transformableNode = new TransformableNode(arFragment.getTransformationSystem());
            transformableNode.setParent(anchorNode);
            transformableNode.setRenderable(DiningSet4renderable);
            transformableNode.select();
        }
        if(selected==18){
            TransformableNode transformableNode = new TransformableNode(arFragment.getTransformationSystem());
            transformableNode.setParent(anchorNode);
            transformableNode.setRenderable(DiningSet6renderable);
            transformableNode.select();
        }
        if(selected==19){
            TransformableNode transformableNode = new TransformableNode(arFragment.getTransformationSystem());
            transformableNode.setParent(anchorNode);
            transformableNode.setRenderable(DiningSet7renderable);
            transformableNode.select();
        }
        if(selected==20){
            TransformableNode transformableNode = new TransformableNode(arFragment.getTransformationSystem());
            transformableNode.setParent(anchorNode);
            transformableNode.setRenderable(DiningSet8renderable);
            transformableNode.select();
        }
        if(selected==21){
            TransformableNode transformableNode = new TransformableNode(arFragment.getTransformationSystem());
            transformableNode.setParent(anchorNode);
            transformableNode.setRenderable(DiningTable1renderable);
            transformableNode.select();
        }
        if(selected==22){
            TransformableNode transformableNode = new TransformableNode(arFragment.getTransformationSystem());
            transformableNode.setParent(anchorNode);
            transformableNode.setRenderable(DiningTable2renderable);
            transformableNode.select();
        }
        if(selected==23){
            TransformableNode transformableNode = new TransformableNode(arFragment.getTransformationSystem());
            transformableNode.setParent(anchorNode);
            transformableNode.setRenderable(DiningTable3renderable);
            transformableNode.select();
        }
        if(selected==24){
            TransformableNode transformableNode = new TransformableNode(arFragment.getTransformationSystem());
            transformableNode.setParent(anchorNode);
            transformableNode.setRenderable(DiningTable4renderable);
            transformableNode.select();
        }
        if(selected==25){
            TransformableNode transformableNode = new TransformableNode(arFragment.getTransformationSystem());
            transformableNode.setParent(anchorNode);
            transformableNode.setRenderable(DiningTable5renderable);
            transformableNode.select();
        }
        if(selected==26){
            TransformableNode transformableNode = new TransformableNode(arFragment.getTransformationSystem());
            transformableNode.setParent(anchorNode);
            transformableNode.setRenderable(Armchair1renderable);
            transformableNode.select();
        }
        if(selected==27){
            TransformableNode transformableNode = new TransformableNode(arFragment.getTransformationSystem());
            transformableNode.setParent(anchorNode);
            transformableNode.setRenderable(Armchair2renderable);
            transformableNode.select();
        }
        if(selected==28){
            TransformableNode transformableNode = new TransformableNode(arFragment.getTransformationSystem());
            transformableNode.setParent(anchorNode);
            transformableNode.setRenderable(Chair1renderable);
            transformableNode.select();
        }
        if(selected==29){
            TransformableNode transformableNode = new TransformableNode(arFragment.getTransformationSystem());
            transformableNode.setParent(anchorNode);
            transformableNode.setRenderable(Chair3renderable);
            transformableNode.select();
        }
        if(selected==30){
            TransformableNode transformableNode = new TransformableNode(arFragment.getTransformationSystem());
            transformableNode.setParent(anchorNode);
            transformableNode.setRenderable(Chair4renderable);
            transformableNode.select();
        }
        if(selected==31){
            TransformableNode transformableNode = new TransformableNode(arFragment.getTransformationSystem());
            transformableNode.setParent(anchorNode);
            transformableNode.setRenderable(Chair5renderable);
            transformableNode.select();
        }
        if(selected==32){
            TransformableNode transformableNode = new TransformableNode(arFragment.getTransformationSystem());
            transformableNode.setParent(anchorNode);
            transformableNode.setRenderable(bedsidetablerenderable);
            transformableNode.select();
        }
        if(selected==33){
            TransformableNode transformableNode = new TransformableNode(arFragment.getTransformationSystem());
            transformableNode.setParent(anchorNode);
            transformableNode.setRenderable(desk1renderable);
            transformableNode.select();
        }
        if(selected==34){
            TransformableNode transformableNode = new TransformableNode(arFragment.getTransformationSystem());
            transformableNode.setParent(anchorNode);
            transformableNode.setRenderable(desk2renderable);
            transformableNode.select();
        }
        if(selected==35){
            TransformableNode transformableNode = new TransformableNode(arFragment.getTransformationSystem());
            transformableNode.setParent(anchorNode);
            transformableNode.setRenderable(desk3renderable);
            transformableNode.select();
        }
        if(selected==36){
            TransformableNode transformableNode = new TransformableNode(arFragment.getTransformationSystem());
            transformableNode.setParent(anchorNode);
            transformableNode.setRenderable(fan1renderable);
            transformableNode.select();
        }
        if(selected==37){
            TransformableNode transformableNode = new TransformableNode(arFragment.getTransformationSystem());
            transformableNode.setParent(anchorNode);
            transformableNode.setRenderable(fan2renderable);
            transformableNode.select();
        }
        if(selected==38){
            TransformableNode transformableNode = new TransformableNode(arFragment.getTransformationSystem());
            transformableNode.setParent(anchorNode);
            transformableNode.setRenderable(kitchen1renderable);
            transformableNode.select();
        }
        if(selected==39){
            TransformableNode transformableNode = new TransformableNode(arFragment.getTransformationSystem());
            transformableNode.setParent(anchorNode);
            transformableNode.setRenderable(kitchen2renderable);
            transformableNode.select();
        }
        if(selected==40){
            TransformableNode transformableNode = new TransformableNode(arFragment.getTransformationSystem());
            transformableNode.setParent(anchorNode);
            transformableNode.setRenderable(pianorenderable);
            transformableNode.select();
        }
        if(selected==41){
            TransformableNode transformableNode = new TransformableNode(arFragment.getTransformationSystem());
            transformableNode.setParent(anchorNode);
            transformableNode.setRenderable(stoverenderable);
            transformableNode.select();
        }
        if(selected==42){
            TransformableNode transformableNode = new TransformableNode(arFragment.getTransformationSystem());
            transformableNode.setParent(anchorNode);
            transformableNode.setRenderable(tvrenderable);
            transformableNode.select();
        }
        if(selected==43){
            TransformableNode transformableNode = new TransformableNode(arFragment.getTransformationSystem());
            transformableNode.setParent(anchorNode);
            transformableNode.setRenderable(washingmachinerenderable);
            transformableNode.select();
        }
        if(selected==44){
            TransformableNode transformableNode = new TransformableNode(arFragment.getTransformationSystem());
            transformableNode.setParent(anchorNode);
            transformableNode.setRenderable(sofa1renderable);
            transformableNode.select();
        }
        if(selected==45){
            TransformableNode transformableNode = new TransformableNode(arFragment.getTransformationSystem());
            transformableNode.setParent(anchorNode);
            transformableNode.setRenderable(sofa2renderable);
            transformableNode.select();
        }
        if(selected==46){
            TransformableNode transformableNode = new TransformableNode(arFragment.getTransformationSystem());
            transformableNode.setParent(anchorNode);
            transformableNode.setRenderable(sofa3renderable);
            transformableNode.select();
        }
        if(selected==47){
            TransformableNode transformableNode = new TransformableNode(arFragment.getTransformationSystem());
            transformableNode.setParent(anchorNode);
            transformableNode.setRenderable(sofa4renderable);
            transformableNode.select();
        }
        if(selected==48){
            TransformableNode transformableNode = new TransformableNode(arFragment.getTransformationSystem());
            transformableNode.setParent(anchorNode);
            transformableNode.setRenderable(sofa6renderable);
            transformableNode.select();
        }
        if(selected==49){
            TransformableNode transformableNode = new TransformableNode(arFragment.getTransformationSystem());
            transformableNode.setParent(anchorNode);
            transformableNode.setRenderable(sofa7renderable);
            transformableNode.select();
        }
        if(selected==50){
            TransformableNode transformableNode = new TransformableNode(arFragment.getTransformationSystem());
            transformableNode.setParent(anchorNode);
            transformableNode.setRenderable(sofa8renderable);
            transformableNode.select();
        }
        if(selected==51){
            TransformableNode transformableNode = new TransformableNode(arFragment.getTransformationSystem());
            transformableNode.setParent(anchorNode);
            transformableNode.setRenderable(sofa9renderable);
            transformableNode.select();
        }
        if(selected==52){
            TransformableNode transformableNode = new TransformableNode(arFragment.getTransformationSystem());
            transformableNode.setParent(anchorNode);
            transformableNode.setRenderable(sofa10renderable);
            transformableNode.select();
        }
        if(selected==53){
            TransformableNode transformableNode = new TransformableNode(arFragment.getTransformationSystem());
            transformableNode.setParent(anchorNode);
            transformableNode.setRenderable(sofa11renderable);
            transformableNode.select();
        }

    }

    private void setonclicklistener() {

        distbetweenpts.setOnClickListener(this);
        for(int i=0; i<bed.length;i++) {
            bed[i].setOnClickListener(this);
        }
        for(int i=0; i<Cupb.length;i++){
            Cupb[i].setOnClickListener(this);
        }
        for(int i=0; i<DiningSets.length;i++){
            DiningSets[i].setOnClickListener(this);
        }
        for(int i=0; i<DiningTables.length;i++){
            DiningTables[i].setOnClickListener(this);
        }
        for(int i=0; i<DiningChair.length;i++){
            DiningChair[i].setOnClickListener(this);
        }
        for(int i=0; i<Miscellanous.length;i++){
            Miscellanous[i].setOnClickListener(this);
        }
        for(int i=0; i<Sofa.length;i++){
            Sofa[i].setOnClickListener(this);
        }


    }

    private void setlongonclicklistener(){
        for(int i=0; i<bed.length;i++) {
            bed[i].setOnLongClickListener(this);
        }
        for(int i=0; i<Cupb.length;i++) {
            Cupb[i].setOnLongClickListener(this);
        }
        for(int i=0; i<DiningSets.length;i++){
            DiningSets[i].setOnLongClickListener(this);
        }
        for(int i=0; i<DiningTables.length;i++){
            DiningTables[i].setOnLongClickListener(this);
        }
        for(int i=0; i<DiningChair.length;i++){
            DiningChair[i].setOnLongClickListener(this);
        }
        for(int i=0; i<Miscellanous.length;i++){
            Miscellanous[i].setOnLongClickListener(this);
        }
        for(int i=0; i<Sofa.length;i++){
            Sofa[i].setOnLongClickListener(this);
        }


    }

    private void arrayviewset() {
        bed=new View[]{Bed1, Bed2, Bed3, Bed4};
        Cupb=new View[]{ Cupb1, Cupb2, Cupb3, Cupb4, Cupb5, Cupb6, Cupb7, Cupb8};
        DiningSets=new View[]{ DiningSet0, DiningSet1, DiningSet2, DiningSet3, DiningSet4, DiningSet6, DiningSet7, DiningSet8};
        DiningTables=new View[]{ DiningTable1, DiningTable2, DiningTable3, DiningTable4, DiningTable5};
        DiningChair=new View[]{ Armchair1, Armchair2, Chair1, Chair3, Chair4, Chair5};
        Miscellanous=new View[]{ bedsidetable, desk1, desk2, desk3, fan1, fan2, kitchen1, kitchen2, piano, stove, tv, washingmachine};
        Sofa=new View[]{sofa1, sofa2, sofa3, sofa4, sofa6, sofa7, sofa8, sofa9, sofa10, sofa11};
    }

    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.distbetweenpts) {
            selected = 0;
            sethighlight(v.getId());
        }
        if (v.getId() == R.id.Bed1){
            selected = 1;
        sethighlight(v.getId());}
        else if (v.getId() == R.id.Bed2){
            selected = 2;
            sethighlight(v.getId());}
        else if (v.getId() == R.id.Bed3){
            selected = 3;
            sethighlight(v.getId()); }
        else if (v.getId() == R.id.Bed4){
            selected = 4;
            sethighlight(v.getId());}
        else if (v.getId() == R.id.Cupboard1){
            selected = 5;
            sethighlight(v.getId());}
        else if (v.getId() == R.id.Cupboard2){
            selected = 6;
            sethighlight(v.getId());}
        else if (v.getId() == R.id.Cupboard3){
            selected = 7;
            sethighlight(v.getId());}
        else if (v.getId() == R.id.Cupboard4){
            selected = 8; sethighlight(v.getId());}
        else if (v.getId() == R.id.Cupboard5){
            selected = 9; sethighlight(v.getId());}
        else if (v.getId() == R.id.Cupboard6){
            selected = 10; sethighlight(v.getId());}
        else if (v.getId() == R.id.Cupboard7){
            selected = 11; sethighlight(v.getId());}
        else  if (v.getId() == R.id.Cupboard8){
            selected = 12; sethighlight(v.getId());}
        else if (v.getId() == R.id.DiningSet0){
            selected = 13; sethighlight(v.getId());}
        else if (v.getId() == R.id.DiningSet1){
            selected = 14; sethighlight(v.getId());}
        else if (v.getId() == R.id.DiningSet2){
            selected = 15; sethighlight(v.getId());}
        else if (v.getId() == R.id.DiningSet3){
            selected = 16; sethighlight(v.getId());}
        else if (v.getId() == R.id.DiningSet4){
            selected = 17; sethighlight(v.getId());}
        else if (v.getId() == R.id.DiningSet6){
            selected = 18; sethighlight(v.getId());}
        else if (v.getId() == R.id.DiningSet7){
            selected = 19; sethighlight(v.getId());}
        else if (v.getId() == R.id.DiningSet8){
            selected = 20; sethighlight(v.getId());}
        else if (v.getId() == R.id.DiningTable1){
            selected = 21; sethighlight(v.getId());}
        else if (v.getId() == R.id.DiningTable2){
            selected = 22; sethighlight(v.getId());}
        else if (v.getId() == R.id.DiningTable3){
            selected = 23; sethighlight(v.getId());}
        else if (v.getId() == R.id.DiningTable4){
            selected = 24; sethighlight(v.getId());}
        else if (v.getId() == R.id.DiningTable5){
            selected = 25; sethighlight(v.getId());}
        else if (v.getId() == R.id.Armchair1){
            selected = 26; sethighlight(v.getId());}
        else if (v.getId() == R.id.Armchair2){
            selected = 27; sethighlight(v.getId());}
        else if (v.getId() == R.id.Chair1){
            selected = 28; sethighlight(v.getId());}
        else if (v.getId() == R.id.Chair3){
            selected = 29; sethighlight(v.getId());}
        else if (v.getId() == R.id.Chair4){
            selected = 30; sethighlight(v.getId());}
        else if (v.getId() == R.id.Chair5){
            selected = 31; sethighlight(v.getId());}
        else if (v.getId() == R.id.Bedsidetable){
            selected = 32; sethighlight(v.getId());}
        else if (v.getId() == R.id.Desk1){
            selected = 33; sethighlight(v.getId());}
        else if (v.getId() == R.id.Desk2){
            selected = 34; sethighlight(v.getId());}
        else  if (v.getId() == R.id.Desk3){
            selected = 35; sethighlight(v.getId());}
        else if (v.getId() == R.id.Fan1){
            selected = 36; sethighlight(v.getId());}
        else if (v.getId() == R.id.Fan2){
            selected = 37; sethighlight(v.getId());}
        else if (v.getId() == R.id.Kitchen1){
            selected = 38; sethighlight(v.getId());}
        else if (v.getId() == R.id.Kitchen2){
            selected = 39; sethighlight(v.getId());}
        else if (v.getId() == R.id.Piano){
            selected = 40; sethighlight(v.getId());}
        else if (v.getId() == R.id.Stove){
            selected = 41; sethighlight(v.getId());}
        else if (v.getId() == R.id.TV){
            selected = 42; sethighlight(v.getId());}
        else if (v.getId() == R.id.WashingMachine){
            selected = 43; sethighlight(v.getId());}
        else if (v.getId() == R.id.Sofa1){
            selected = 44; sethighlight(v.getId());}
        else if (v.getId() == R.id.Sofa2){
            selected = 45; sethighlight(v.getId());}
        else if (v.getId() == R.id.Sofa3){
            selected = 46; sethighlight(v.getId());}
        else if (v.getId() == R.id.Sofa4){
            selected = 47; sethighlight(v.getId());}
        else if (v.getId() == R.id.Sofa6){
            selected = 48; sethighlight(v.getId());}
        else if (v.getId() == R.id.Sofa7){
            selected = 49; sethighlight(v.getId());}
        else if (v.getId() == R.id.Sofa8){
            selected = 50; sethighlight(v.getId());}
        else if (v.getId() == R.id.Sofa9){
            selected = 51; sethighlight(v.getId());}
        else if (v.getId() == R.id.Sofa10){
            selected = 52; sethighlight(v.getId());}
        else if (v.getId() == R.id.Sofa11){
            selected = 53; sethighlight(v.getId());}

    }

    private void sethighlight(int id) {
        Drawable highlight =getResources().getDrawable(R.drawable.higlightimage);

        if(id == R.id.distbetweenpts){
            distbetweenpts.setBackground(highlight);
        }
        else {
            distbetweenpts.setBackgroundColor(Color.TRANSPARENT);
        }
        for(int i=0; i<bed.length;i++) {
            if(bed[i].getId()==id)
                bed[i].setBackground(highlight);
            else
                bed[i].setBackgroundColor(Color.TRANSPARENT);
        }
        for(int i=0; i<Cupb.length;i++){
            if(Cupb[i].getId()==id)
                Cupb[i].setBackground(highlight);
            else
                Cupb[i].setBackgroundColor(Color.TRANSPARENT);
        }
        for(int i=0; i<DiningSets.length;i++){
            if(DiningSets[i].getId()==id)
                DiningSets[i].setBackground(highlight);
            else
                DiningSets[i].setBackgroundColor(Color.TRANSPARENT);
        }
        for(int i=0; i<DiningTables.length;i++){
            if(DiningTables[i].getId()==id)
                DiningTables[i].setBackground(highlight);
            else
                DiningTables[i].setBackgroundColor(Color.TRANSPARENT);
        }
        for(int i=0; i<DiningChair.length;i++){
            if(DiningChair[i].getId()==id)
                DiningChair[i].setBackground(highlight);
            else
                DiningChair[i].setBackgroundColor(Color.TRANSPARENT);
        }
        for(int i=0; i<Miscellanous.length;i++){
            if(Miscellanous[i].getId()==id)
                Miscellanous[i].setBackground(highlight);
            else
                Miscellanous[i].setBackgroundColor(Color.TRANSPARENT);
        }
        for(int i=0; i<Sofa.length;i++){
            if(Sofa[i].getId()==id)
                Sofa[i].setBackground(highlight);
            else
                Sofa[i].setBackgroundColor(Color.TRANSPARENT);
        }




    }

    @Override
    public boolean onLongClick(View v) {

        if(v.getId() == R.id.distbetweenpts) {
            selected = 0;
            sethighlight(v.getId());
        }
        if (v.getId() == R.id.Bed1){
            selected = 1;
            sethighlight(v.getId());}
        else if (v.getId() == R.id.Bed2){
            selected = 2;
            sethighlight(v.getId());}
        else if (v.getId() == R.id.Bed3){
            selected = 3;
            sethighlight(v.getId()); }
        else if (v.getId() == R.id.Bed4){
            selected = 4;
            sethighlight(v.getId());}
        else if (v.getId() == R.id.Cupboard1){
            selected = 5;
            sethighlight(v.getId());}
        else if (v.getId() == R.id.Cupboard2){
            selected = 6;
            sethighlight(v.getId());}
        else if (v.getId() == R.id.Cupboard3){
            selected = 7;
            sethighlight(v.getId());}
        else if (v.getId() == R.id.Cupboard4){
            selected = 8; sethighlight(v.getId());}
        else if (v.getId() == R.id.Cupboard5){
            selected = 9; sethighlight(v.getId());}
        else if (v.getId() == R.id.Cupboard6){
            selected = 10; sethighlight(v.getId());}
        else if (v.getId() == R.id.Cupboard7){
            selected = 11; sethighlight(v.getId());}
        else  if (v.getId() == R.id.Cupboard8){
            selected = 12; sethighlight(v.getId());}
        else if (v.getId() == R.id.DiningSet0){
            selected = 13; sethighlight(v.getId());}
        else if (v.getId() == R.id.DiningSet1){
            selected = 14; sethighlight(v.getId());}
        else if (v.getId() == R.id.DiningSet2){
            selected = 15; sethighlight(v.getId());}
        else if (v.getId() == R.id.DiningSet3){
            selected = 16; sethighlight(v.getId());}
        else if (v.getId() == R.id.DiningSet4){
            selected = 17; sethighlight(v.getId());}
        else if (v.getId() == R.id.DiningSet6){
            selected = 18; sethighlight(v.getId());}
        else if (v.getId() == R.id.DiningSet7){
            selected = 19; sethighlight(v.getId());}
        else if (v.getId() == R.id.DiningSet8){
            selected = 20; sethighlight(v.getId());}
        else if (v.getId() == R.id.DiningTable1){
            selected = 21; sethighlight(v.getId());}
        else if (v.getId() == R.id.DiningTable2){
            selected = 22; sethighlight(v.getId());}
        else if (v.getId() == R.id.DiningTable3){
            selected = 23; sethighlight(v.getId());}
        else if (v.getId() == R.id.DiningTable4){
            selected = 24; sethighlight(v.getId());}
        else if (v.getId() == R.id.DiningTable5){
            selected = 25; sethighlight(v.getId());}
        else if (v.getId() == R.id.Armchair1){
            selected = 26; sethighlight(v.getId());}
        else if (v.getId() == R.id.Armchair2){
            selected = 27; sethighlight(v.getId());}
        else if (v.getId() == R.id.Chair1){
            selected = 28; sethighlight(v.getId());}
        else if (v.getId() == R.id.Chair3){
            selected = 29; sethighlight(v.getId());}
        else if (v.getId() == R.id.Chair4){
            selected = 30; sethighlight(v.getId());}
        else if (v.getId() == R.id.Chair5){
            selected = 31; sethighlight(v.getId());}
        else if (v.getId() == R.id.Bedsidetable){
            selected = 32; sethighlight(v.getId());}
        else if (v.getId() == R.id.Desk1){
            selected = 33; sethighlight(v.getId());}
        else if (v.getId() == R.id.Desk2){
            selected = 34; sethighlight(v.getId());}
        else  if (v.getId() == R.id.Desk3){
            selected = 35; sethighlight(v.getId());}
        else if (v.getId() == R.id.Fan1){
            selected = 36; sethighlight(v.getId());}
        else if (v.getId() == R.id.Fan2){
            selected = 37; sethighlight(v.getId());}
        else if (v.getId() == R.id.Kitchen1){
            selected = 38; sethighlight(v.getId());}
        else if (v.getId() == R.id.Kitchen2){
            selected = 39; sethighlight(v.getId());}
        else if (v.getId() == R.id.Piano){
            selected = 40; sethighlight(v.getId());}
        else if (v.getId() == R.id.Stove){
            selected = 41; sethighlight(v.getId());}
        else if (v.getId() == R.id.TV){
            selected = 42; sethighlight(v.getId());}
        else if (v.getId() == R.id.WashingMachine){
            selected = 43; sethighlight(v.getId());}
        else if (v.getId() == R.id.Sofa1){
            selected = 44; sethighlight(v.getId());}
        else if (v.getId() == R.id.Sofa2){
            selected = 45; sethighlight(v.getId());}
        else if (v.getId() == R.id.Sofa3){
            selected = 46; sethighlight(v.getId());}
        else if (v.getId() == R.id.Sofa4){
            selected = 47; sethighlight(v.getId());}
        else if (v.getId() == R.id.Sofa6){
            selected = 48; sethighlight(v.getId());}
        else if (v.getId() == R.id.Sofa7){
            selected = 49; sethighlight(v.getId());}
        else if (v.getId() == R.id.Sofa8){
            selected = 50; sethighlight(v.getId());}
        else if (v.getId() == R.id.Sofa9){
            selected = 51; sethighlight(v.getId());}
        else if (v.getId() == R.id.Sofa10){
            selected = 52; sethighlight(v.getId());}
        else if (v.getId() == R.id.Sofa11){
            selected = 53; sethighlight(v.getId());}

        previewmodel();
        return true;
    }
}

