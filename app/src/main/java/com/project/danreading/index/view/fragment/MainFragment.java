package com.project.danreading.index.view.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.project.danreading.R;
import com.project.danreading.common.base.BaseFragment;
import com.project.danreading.common.model.entity.Item;
import com.project.danreading.common.utils.LogUtil;
import com.project.danreading.common.utils.RxBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MainFragment extends BaseFragment {

    @BindView(R.id.home_advertise_iv)
    ImageView      mHomeAdvertiseIv;
    @BindView(R.id.image_iv)
    ImageView      mImageIv;
    @BindView(R.id.image_type)
    ImageView      mImageType;
    @BindView(R.id.download_start_white)
    ImageView      mDownloadStartWhite;
    @BindView(R.id.topPanel)
    RelativeLayout mTopPanel;
    @BindView(R.id.type_tv)
    TextView       mTypeTv;
    @BindView(R.id.time_tv)
    TextView       mTimeTv;
    @BindView(R.id.typePanel)
    RelativeLayout mTypePanel;
    @BindView(R.id.title_tv)
    TextView       mTitleTv;
    @BindView(R.id.content_tv)
    TextView       mContentTv;
    @BindView(R.id.divider)
    View           mDivider;
    @BindView(R.id.author_tv)
    TextView       mAuthorTv;
    @BindView(R.id.comment_tv)
    TextView       mCommentTv;
    @BindView(R.id.like_tv)
    TextView       mLikeTv;
    @BindView(R.id.readcount_tv)
    TextView       mReadcountTv;
    @BindView(R.id.pager_content)
    RelativeLayout mPagerContent;
    @BindView(R.id.type_container)
    LinearLayout   mTypeContainer;
    Unbinder unbinder;
    private int mModel;
    private Item mItem;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = View.inflate(getContext(), R.layout.fragment_main, null);
        unbinder = ButterKnife.bind(this, root);
        return root;
    }

    public static BaseFragment instance(Item item) {
        MainFragment mainFragment = new MainFragment();
        RxBus.getInstance().postSticky(item);
        return mainFragment;
    }

    @Override
    public void onResume() {
        super.onResume();

        RxBus.getInstance().registerSticky(Item.class, item1 -> {
            mItem = item1;
            mModel = Integer.parseInt(item1.getModel());
        });
        switch (mModel) {
            case 5:
                mPagerContent.setVisibility(View.GONE);
                mHomeAdvertiseIv.setVisibility(View.VISIBLE);
                Glide.with(this.getContext()).load(mItem.getThumbnail()).centerCrop().into(mHomeAdvertiseIv);
                break;
            default:
                LogUtil.d(mModel+"");
                break;
        }
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
